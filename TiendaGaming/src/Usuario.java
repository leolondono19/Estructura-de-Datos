import java.io.*;

public abstract class Usuario implements java.io.Serializable{
	private String nombre;
	private String apellido;
	private String email;
	private String ciudad;
	private String telefono;
	private String contraseña;
	
	public Usuario(String nombre, String apellido, String email, String ciudad, String telefono, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}

