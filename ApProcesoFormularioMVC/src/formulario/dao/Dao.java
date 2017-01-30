package formulario.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import formulario.modelo.beans.Usuario;
import formulario.vista.excepciones.ExcepcionClaveIncorrecta;
import formulario.vista.excepciones.ExcepcionErrorConexionBaseDatos;
import formulario.vista.excepciones.ExcepcionLoginNoEncontrado;

public interface Dao {
	
	
	public Connection getConnection(DataSource ds)throws SQLException;
	
	public void close()throws SQLException;
	
	public void registrarUsr(Usuario usr)throws ExcepcionErrorConexionBaseDatos;

	public Usuario getUsuario(String pNombre, String pClave) throws ExcepcionLoginNoEncontrado, ExcepcionClaveIncorrecta, ExcepcionErrorConexionBaseDatos;
	
}
