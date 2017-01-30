package formulario.controlador;

import formulario.modelo.acciones.AccionIndex;
import formulario.modelo.acciones.AccionLoguear;
import formulario.modelo.acciones.AccionRegistrar;

public abstract class FactoriaAcciones {

	
	public static Accion creaAcciones(String pAccion){
		
		Accion accion=null;
		if(pAccion==null)
			pAccion="";
		switch(pAccion){
		
		case "index":
			accion = new AccionIndex();
			break;
		case "loguear":
			accion = new AccionLoguear();
			break;
		case "registrar":
			accion = new AccionRegistrar();
			break;
			
			default:
			accion = new AccionIndex();
			break;
		}
	
		return accion;
	
	
	}
	
}
