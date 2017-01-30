package formulario.modelo.acciones;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import formulario.controlador.Accion;
import formulario.modelo.beans.Usuario;
import formulario.utilidades.ValidarFormulario;
import formulario.vista.excepciones.ExcepcionAp;

public class AccionIndex implements Accion {
	
	private static final String VISTA ="index.jsp";
	private static final String VISTA_ERROR ="WEB-INF/error.jsp";
	private Usuario usr = null;
	private DataSource ds;
	private ServletContext contextoAplicacion;
	private ExcepcionAp error;
	private HttpSession session;
	@Override
	public boolean ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean seguir=true;

			return seguir;
		
	}
	@Override
	public String getVista() {
		
		return VISTA;
	}
	public String getVistaError() {
		
		return VISTA_ERROR;
	}
	@Override
	public Object getModelo() {
		
		return this.usr;
	}

	@Override
	public void setDataSource(DataSource ds) {
		this.ds=ds;
		
	}

	@Override
	public void setSc(ServletContext sc) {
		
		this.contextoAplicacion=sc;
		
	}

	@Override
	public ExcepcionAp getError() {
		
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
