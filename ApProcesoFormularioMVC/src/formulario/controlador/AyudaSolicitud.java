package formulario.controlador;

import javax.servlet.http.HttpServletRequest;

public class AyudaSolicitud {
	
	HttpServletRequest request;
	
	
public AyudaSolicitud(HttpServletRequest request) {
	
	this.request = request;
}

public Accion getAccion(){
	
	return FactoriaAcciones.creaAcciones(request.getParameter("accion"));
}

}
