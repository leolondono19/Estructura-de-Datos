import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Comprador extends Usuario {
	
	private Connection connection;
	
	public Comprador(Connection myConnection, String nombre, String apellido, String email, String ciudad, String telefono, String contraseña) {
		super(nombre, apellido, email, ciudad, telefono, contraseña);
	}
	
	public Comprador(Connection myConnection) {
		super(null, null, null, null, null, null);
		connection = myConnection;
	}
	
	public void registrarComprador(Comprador comprador) {
		Connection conn = Conexion.crearConexion();
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into Compradores values(?,?,?,?,?,?,?)");
			stmt.setInt(1, 1);
			stmt.setString(2, comprador.getNombre());
			stmt.setString(3, comprador.getApellido());
			stmt.setString(4, comprador.getEmail());
			stmt.setString(5, comprador.getCiudad());
			stmt.setString(6, comprador.getContraseña());
			stmt.setString(7, comprador.getTelefono());
			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean EsCompradorValido(String userName, String password) {
		try {
			Statement st = connection.createStatement();
			String sql = ("SELECT * FROM Compradores WHERE nombre ='" + userName + "';");
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				String compradorPassword = rs.getString("contrasena");
				if(compradorPassword.equals(password))
					return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
	}
}
