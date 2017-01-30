package formulario.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import formulario.modelo.beans.Usuario;
import formulario.vista.excepciones.ExcepcionAp;
import formulario.vista.excepciones.ExcepcionClaveIncorrecta;
import formulario.vista.excepciones.ExcepcionErrorConexionBaseDatos;
import formulario.vista.excepciones.ExcepcionLoginNoEncontrado;

public class BeanDao implements Dao{

	
	
	private Connection conexion;
	

	
	private ExcepcionAp error;
	

	
	public BeanDao(){
		
		
		
	}
	
	@Override
	public Connection getConnection(DataSource ds) throws SQLException {
		this.conexion = ds.getConnection();
		return this.conexion;
	}

	@Override
	public void close() throws SQLException {
		if(this.conexion!=null)
			this.conexion.close();
		else
			this.conexion=null;
	}

	 

	

	@Override
	public Usuario getUsuario(String pNombre,String pClave) throws ExcepcionLoginNoEncontrado, ExcepcionClaveIncorrecta, ExcepcionErrorConexionBaseDatos {
		Statement st = null;
		ResultSet rs = null;
		
		
		Usuario usr=new Usuario();
		
		if(this.conexion!=null){
		
		try {
				
			st = this.conexion.createStatement();
			rs = st.executeQuery("select login,clave from usuario where login='"+pNombre+"'");
			if(rs.next()){
				if(pClave.equals(rs.getString(2))){
				usr.setLogin(rs.getString(1));
				usr.setClave(rs.getString(2));
				}else{
					throw new ExcepcionClaveIncorrecta("La clave es incorrecta.");
				}
					 
				
			}else{
				throw new ExcepcionLoginNoEncontrado("El login no se encuentra en la base de datos");
				
				}
			} catch (SQLException e) {
			System.out.println("Error en la conexión a la base de datos");
									}
		
	finally{
			try{
				if(st!=null)
					st.close();
					
					if(rs!=null)
						rs.close();
				
				}catch(SQLException e){
				System.out.println("Error al cerrar la conexión");
									}
			}
			
		
		}else{
			
			throw new ExcepcionErrorConexionBaseDatos("Se ha perdido la conexión a la base de datos.");
			}
		

		
		return usr;
	}
     


	@Override
	public void registrarUsr(Usuario usr) throws ExcepcionErrorConexionBaseDatos {
		
		Statement st=null;
		int resultado=0;
		
		if(this.conexion!=null){
			
			try {
				st=this.conexion.createStatement();
				resultado=st.executeUpdate("insert into usuario values('"+usr.getLogin()+"','"+usr.getClave()+"');");
				System.out.println(resultado);
			
			} catch (SQLException e) {
				System.out.println("Error en la conexión a la base de datos");
			}
			
			finally{
				try{
					if(st!=null)
						st.close();
				}catch(SQLException sql){
					
				}
				
			}
			
		}else{
			
		throw new ExcepcionErrorConexionBaseDatos("Error en la conexión a la base de datos.");	
			
		}
		
	}

	
    	 
    	 
     }

