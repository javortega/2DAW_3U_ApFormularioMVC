package formulario.modelo.acciones;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import formulario.controlador.Accion;
import formulario.dao.BeanDao;
import formulario.modelo.beans.Usuario;
import formulario.utilidades.ValidarFormulario;
import formulario.vista.excepciones.ExcepcionAp;
import formulario.vista.excepciones.ExcepcionClaveIncorrecta;
import formulario.vista.excepciones.ExcepcionErrorConexionBaseDatos;
import formulario.vista.excepciones.ExcepcionLoginNoEncontrado;

public class AccionRegistrar implements Accion {
	
	private static final String VISTA ="WEB-INF/resultadoregistro.jsp";
	private static final String VISTA_ERROR ="WEB-INF/error.jsp";
	private Usuario usr = null;
	private DataSource ds;
	private ServletContext contextoAplicacion;
	private ExcepcionAp error;
	private HttpSession session;
	private BeanDao beanDao;
	
	@Override
	public boolean ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean seguir=false;
		if(ValidarFormulario.isOk(request.getParameter("login"), request.getParameter("clave"))){
			seguir=true;
			this.usr=new Usuario(request.getParameter("login"), request.getParameter("clave"));
			this.beanDao=new BeanDao();
			try {
				this.beanDao.getConnection(this.ds);
				this.beanDao.registrarUsr(this.usr);
				this.beanDao.close();
			} 
			catch(ExcepcionErrorConexionBaseDatos ecbd){
				this.error=ecbd;
				seguir=false;
			
			}catch (SQLException e) {
				System.out.println("Error en la conexión a la base de datos.");
				seguir=false;
			}
			
			return seguir;
		}else{
			
			return seguir;
		}
	
	}

	@Override
	public String getVista() {
		
		return VISTA;
	}
	public String getVistaError() {
		// TODO Auto-generated method stub
		return VISTA_ERROR;
	}
	@Override
	public Object getModelo() {
		// TODO Auto-generated method stub
		return this.usr;
	}

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.ds=ds;
	}

	@Override
	public void setSc(ServletContext sc) {
		// TODO Auto-generated method stub
		this.contextoAplicacion=sc;
	}

	@Override
	public ExcepcionAp getError() {
		// TODO Auto-generated method stub
		return this.error;
	}

	@Override
	public void setSession(HttpSession session) {
		this.session=session;
		
	}

	@Override
	public HttpSession getSession() {
		
		return this.session;
	}

}
