import java.sql.*;



public class Administrador extends Usuario implements java.io.Serializable{
	private String CodigoSecreto = "1010";
	private Connection connection;
	public String getCodigoSecreto() {
		return CodigoSecreto;
	}
	
	public void setCodigoSecreto(String codigoSecreto) {
		CodigoSecreto = codigoSecreto;
	}
	
	public Administrador(Connection myConnection,String nombre, String apellido, String email, String ciudad, String telefono,
			String contraseña) {
		super(nombre, apellido, email, ciudad, telefono, contraseña);
		
		connection = myConnection;
	}
	
	
	
	public Administrador(Connection myConnection) {
		super(null, null, null, null, null, null);
		connection = myConnection;
	}

	public void registrarAdmin(Administrador admin) {
		try {
			PreparedStatement stmt = connection.prepareStatement("insert into Administradores (nombre, apellido, email, ciudad, contrasena, telefono)" + "values(?,?,?,?,?,?)");
			stmt.setString(1, admin.getNombre());
			stmt.setString(2, admin.getApellido());
			stmt.setString(3, admin.getEmail());
			stmt.setString(4, admin.getCiudad());
			stmt.setString(5, admin.getContraseña());
			stmt.setString(6, admin.getTelefono());
			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void leerAdministrador(String name) {
		Statement st;
		try {
			st = connection.createStatement();
			String sql = ("SELECT * FROM Administradores;");
			ResultSet rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean EsAdministratorValido(String userName, String password) {
		try {
			Statement st = connection.createStatement();
			String sql = ("SELECT * FROM Administradores WHERE nombre ='" + userName + "';");
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				String adminPassword = rs.getString("contrasena");
				if(adminPassword.equals(password))
					return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
	}
}
