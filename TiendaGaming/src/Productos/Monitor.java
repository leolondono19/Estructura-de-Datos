package Productos;

import java.sql.*;

public class Monitor extends Producto implements java.io.Serializable {
	private float TamañoPantalla;
	private String Resolucion;
	private String TipoPanel;
	private boolean HDMI;
	private static Connection connection;
	public Monitor(Connection myConnection, String descripcion, float precio, String marca, String modelo, int stock, int garantiaMeses,
			float tamañoPantalla, String resolucion, String tipoPanel, boolean hDMI) {
		super(descripcion, precio, marca, modelo, stock, garantiaMeses);
		TamañoPantalla = tamañoPantalla;
		Resolucion = resolucion;
		TipoPanel = tipoPanel;
		HDMI = hDMI;
		connection = myConnection;
	}
	
	public static void setConnection(Connection conn)
	{
		connection = conn;
	}
	
	public float getTamañoPantalla() {
		return TamañoPantalla;
	}
	public void setTamañoPantalla(float tamañoPantalla) {
		TamañoPantalla = tamañoPantalla;
	}
	public String getResolucion() {
		return Resolucion;
	}
	public void setResolucion(String resolucion) {
		Resolucion = resolucion;
	}
	public String getTipoPanel() {
		return TipoPanel;
	}
	public void setTipoPanel(String tipoPanel) {
		TipoPanel = tipoPanel;
	}
	public boolean isHDMI() {
		return HDMI;
	}
	public void setHDMI(boolean hDMI) {
		HDMI = hDMI;
	}
	
	 public static ResultSet obtenerDatos() throws SQLException {
	        String consulta = "SELECT * FROM Monitores";
	        PreparedStatement statement = connection.prepareStatement(consulta);
	        return statement.executeQuery();
	 }
	
}
