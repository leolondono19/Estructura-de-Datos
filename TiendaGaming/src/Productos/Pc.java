package Productos;

import java.sql.*;

public class Pc {
	private String procesador;
	private int MemoriaRam;
	private String Almacenamiento;
	private String TarjetaGrafica;
	private String SistemaOperativo;
	private static Connection connection;
	
	public Pc(Connection myConnection, String procesador, int memoriaRam, String almacenamiento, String tarjetaGrafica,
			String sistemaOperativo) {
		super();
		this.procesador = procesador;
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

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
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
        String consulta = "SELECT * FROM PCs_Escritorio";
        PreparedStatement statement = connection.prepareStatement(consulta);
        return statement.executeQuery();
	}
	
	
}
