import java.sql.*;

public class Conexion {
	static final String URL = "jdbc:postgresql://192.168.170.155:5555/Ejemplo1";
	static final String USER = "postgres";
	static final String PASS = "admin";
	
	Connection conn = null;
	
	public static Connection crearConexion() {
	try {
		Class.forName("org.postgresql.Driver");
		Connection conexion = DriverManager.getConnection(URL, USER, PASS);
		System.out.print("Conexion establecida...");
		return conexion;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
		
		}
		return null;
	}
}
