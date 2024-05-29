package Productos;

import java.sql.*;

public class Raton {
	private String TipoConexion;
	private int DPI;
	private boolean BotonesProgramables; 
	private String TipoSensor;
	private static Connection connection;
	
	public Raton(Connection myConnection, String tipoConexion, int dPI, boolean botonesProgramables, String tipoSensor) {
		super();
		TipoConexion = tipoConexion;
		DPI = dPI;
		BotonesProgramables = botonesProgramables;
		TipoSensor = tipoSensor;
		
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

	public int getDPI() {
		return DPI;
	}

	public void setDPI(int dPI) {
		DPI = dPI;
	}

	public boolean isBotonesProgramables() {
		return BotonesProgramables;
	}

	public void setBotonesProgramables(boolean botonesProgramables) {
		BotonesProgramables = botonesProgramables;
	}

	public String getTipoSensor() {
		return TipoSensor;
	}

	public void setTipoSensor(String tipoSensor) {
		TipoSensor = tipoSensor;
	}
	
	public static ResultSet obtenerDatos() throws SQLException {
        String consulta = "SELECT * FROM Ratones";
        PreparedStatement statement = connection.prepareStatement(consulta);
        return statement.executeQuery();
	}
	
	
}
