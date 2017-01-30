package formulario.vista.excepciones;

public class ExcepcionClaveIncorrecta extends ExcepcionAp {
	
	public ExcepcionClaveIncorrecta(String mensaje){
		super(mensaje);
		
	}

	public String getMensajeError(){
		
		return this.mensaje;
	}
}
