package Productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Laptop extends Producto implements java.io.Serializable {
	private float PantallaPulgadas;
	private float PesoKg;
	private String Procesador;
	private int MemoriaRam;
	private String Almacenamiento; 
	private String TarjetaGrafica;
	private String SistemaOperativo;
	private static Connection connection;
	public Laptop(Connection myConnection, String descripcion, float precio, String marca, String modelo, int stock, int garantiaMeses,
			float pantallaPulgadas, float pesoKg, String procesador, int memoriaRam, String almacenamiento,
			String tarjetaGrafica, String sistemaOperativo) {
		super(descripcion, precio, marca, modelo, stock, garantiaMeses);
		PantallaPulgadas = pantallaPulgadas;
		PesoKg = pesoKg;
		Procesador = procesador;
		MemoriaRam = memoriaRam;
		Almacenamiento = almacenamiento;
		TarjetaGrafica = tarjetaGrafica;
		SistemaOperativo = sistemaOperativo;
		
		connection = myConnection;
	}
	
	public static void setConnection(Connection conn)
	{
		connection = conn;
	}

	public float getPantallaPulgadas() {
		return PantallaPulgadas;
	}

	public void setPantallaPulgadas(float pantallaPulgadas) {
		PantallaPulgadas = pantallaPulgadas;
	}

	public float getPesoKg() {
		return PesoKg;
	}

	public void setPesoKg(float pesoKg) {
		PesoKg = pesoKg;
	}

	public String getProcesador() {
		return Procesador;
	}

	public void setProcesador(String procesador) {
		Procesador = procesador;
	}

	public int getMemoriaRam() {
		return MemoriaRam;
	}

	public void setMemoriaRam(int memoriaRam) {
		MemoriaRam = memoriaRam;
	}

	public String getAlmacenamiento() {
		return Almacenamiento;
	}

	public void setAlmacenamiento(String almacenamiento) {
		Almacenamiento = almacenamiento;
	}

	public String getTarjetaGrafica() {
		return TarjetaGrafica;
	}

	public void setTarjetaGrafica(String tarjetaGrafica) {
		TarjetaGrafica = tarjetaGrafica;
	}

	public String getSistemaOperativo() {
		return SistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		SistemaOperativo = sistemaOperativo;
	}
	
	public static ResultSet obtenerDatos() throws SQLException {
        String consulta = "SELECT * FROM Laptops";
        PreparedStatement statement = connection.prepareStatement(consulta);
        return statement.executeQuery();
 }
	
	
	
	
}
