package formulario.controlador;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import formulario.utilidades.ValidarFormulario;

public class Controlador extends HttpServlet {

	private DataSource ds;
	
	private ServletContext contextoAplicacion;
	
	
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		try {
		InitialContext inicioCon = new InitialContext();
		
		this.contextoAplicacion = config.getServletContext();
		this.ds=(DataSource) inicioCon.lookup(config.getInitParameter("datasource"));
		
		} catch (NamingException e) {
			this.contextoAplicacion.setInitParameter("dsPerdido", "true");
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	
		doPost(request,response);
}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Accion accion=null;
		
		
		
		AyudaSolicitud ayuda = new AyudaSolicitud(request);
		
		accion=ayuda.getAccion();
		
		accion.setDataSource(this.ds);
		
		accion.setSc(this.contextoAplicacion);
		
		accion.setSession(request.getSession());
		
		if(accion.ejecutar(request, response)){
			
			if(accion.getModelo()==null){
				RequestDispatcher rd =request.getRequestDispatcher(accion.getVista());
				
				request.setAttribute("inicio", "false");
				
				rd.forward(request, response);
			}else{
				RequestDispatcher rd =request.getRequestDispatcher(accion.getVista());
				request.setAttribute("modelo", accion.getModelo());
				rd.forward(request, response);
				
			}
		}else{
			if(accion.getError()!=null){
				RequestDispatcher rd =request.getRequestDispatcher(accion.getVistaError());
				
				request.setAttribute("error", accion.getError());
				
				rd.forward(request, response);
			}else{
				RequestDispatcher rd =request.getRequestDispatcher("index.jsp");
				request.setAttribute("inicio", "false");
				request.setAttribute("validacion", "Ningún campo debe estar vacío.");
				rd.forward(request, response);
			}
			
			
		}
		
		
		
		
		
		
	}
}