package Productos;

public abstract class Producto implements java.io.Serializable {
	private String Descripcion;
	private float Precio;
	private String Marca;
	private String Modelo;
	private int Stock;
	private int GarantiaMeses;
	
	public Producto(String descripcion, float precio, String marca, String modelo, int stock, int garantiaMeses) {
		super();
		Descripcion = descripcion;
		Precio = precio;
		Marca = marca;
		Modelo = modelo;
		Stock = stock;
		GarantiaMeses = garantiaMeses;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public float getPrecio() {
		return Precio;
	}

	public void setPrecio(float precio) {
		Precio = precio;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public int getGarantiaMeses() {
		return GarantiaMeses;
	}

	public void setGarantiaMeses(int garantiaMeses) {
		GarantiaMeses = garantiaMeses;
	}
}



