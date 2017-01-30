package formulario.controlador;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import formulario.vista.excepciones.*;

public interface Accion {
	
	public boolean ejecutar(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException;
	
	public String getVista();
	
	public String getVistaError();
	
	public Object getModelo();
	
	public void setDataSource(DataSource ds);
	
	public void setSc(ServletContext sc);
	
	public ExcepcionAp getError();
	
	public void setSession(HttpSession session);
	
	public HttpSession getSession();
}
