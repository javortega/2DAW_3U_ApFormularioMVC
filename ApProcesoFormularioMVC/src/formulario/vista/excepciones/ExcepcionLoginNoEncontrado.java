package formulario.vista.excepciones;

public class ExcepcionLoginNoEncontrado extends ExcepcionAp {
	
	public ExcepcionLoginNoEncontrado(String mensaje){
		super(mensaje);
		
	}

	public String getMensajeError(){
		
		return this.mensaje;
	}
}
