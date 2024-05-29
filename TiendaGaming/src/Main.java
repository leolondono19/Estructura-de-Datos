import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		WindowModel principalWindow = new  WindowModel();
		principalWindow.SetConnection(Conexion.crearConexion());
		principalWindow.setVisible(true);
	}

}
