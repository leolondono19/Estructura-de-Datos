package Productos;

import java.sql.*;

public class Teclado extends Producto implements java.io.Serializable {
	private String TipoConexion;
	private boolean RetroIluminacion;
	private boolean TeclasProgramables;
	private static Connection connection;
	public Teclado(Connection myConnection, String descripcion, float precio, String marca, String modelo, int stock, int garantiaMeses,
			String tipoConexion, boolean retroIluminacion, boolean teclasProgramables) {
		super(descripcion, precio, marca, modelo, stock, garantiaMeses);
		TipoConexion = tipoConexion;
		RetroIluminacion = retroIluminacion;
		TeclasProgramables = teclasProgramables;
		
		connection = myConnection;
	}
	
	public static void setConnection(Connection conn)
	{
		connection = conn;
	}
	
	public String getTipoConexion() {
		return TipoConexion;
	}
	public void setTipoConexion(String tipoConexion) {
		TipoConexion = tipoConexion;
	}
	public boolean isRetroIluminacion() {
		return RetroIluminacion;
	}
	public void setRetroIluminacion(boolean retroIluminacion) {
		RetroIluminacion = retroIluminacion;
	}
	public boolean isTeclasProgramables() {
		return TeclasProgramables;
	}
	public void setTeclasProgramables(boolean teclasProgramables) {
		TeclasProgramables = teclasProgramables;
	}
	
	public static ResultSet obtenerDatos() throws SQLException {
        String consulta = "SELECT * FROM Teclados";
        PreparedStatement statement = connection.prepareStatement(consulta);
        return statement.executeQuery();
 }
}
