package formulario.utilidades;

public abstract class ValidarFormulario {
	
	public static boolean isOk(String pLogin,String pClave){
		boolean ok = true;
		
		
		if(pLogin.replace(" ","").length()!=0 && pClave.replace(" ","").length()!=0){
		System.out.println("Ha entrado en el true");	
			return ok;
		}else{
			System.out.println("Ha entrado en false");
			return ok=false;
		}
		}
	

}
