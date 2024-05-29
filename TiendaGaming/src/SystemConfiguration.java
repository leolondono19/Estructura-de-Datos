import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;



public class SystemConfiguration implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Comprador> Compradores = new ArrayList<Comprador>();
	private ArrayList<Administrador> Administradores = new ArrayList<Administrador>();
	

	public SystemConfiguration(ArrayList<Comprador> compradores, ArrayList<Administrador> administradores) {
		super();
		Compradores = compradores;
		Administradores = administradores;
	}
	
	public SystemConfiguration() {
		super();
		Leer();
	}
	
	public void addComprador(Comprador comprador) {
		Compradores.add(comprador);
	}
	
	public void addAdministrador(Administrador administrador) {
		Administradores.add(administrador);
	}
	
	public void setCompradores(ArrayList<Comprador> compradores) {
		Compradores = compradores;
	}
	
	public void setAdministradores(ArrayList<Administrador> administradores) {
		Administradores = administradores;
	}
	
	public boolean EsAdministratorValido(String userName, String password) {
		for (int i = 0; i < Administradores.size(); i++) {
			if(Administradores.get(i).getNombre().equals(userName)) {
				if(Administradores.get(i).getContraseña().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	
	String fileName = "Usuarios.file";
	
	public void Grabar() {
		
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(this);
			
			out.close();
			file.close();
		}
		catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
	}
	public void Leer() {
		try {
			FileInputStream file = new FileInputStream(fileName);
	        ObjectInputStream in = new ObjectInputStream(file);
	        
	        SystemConfiguration config = (SystemConfiguration)in.readObject();
	        this.Compradores = config.Compradores;
	        this.Administradores = config.Administradores;
	        
	        in.close();
	        file.close();
	        
			}
			catch(IOException ex)
	        {
				System.out.println("SI FUNCIONA");
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}