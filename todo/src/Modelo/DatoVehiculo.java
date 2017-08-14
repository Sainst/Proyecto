package Modelo;

public class DatoVehiculo {
	private String n_matricula;
	private String marca;
	private String modelo;
	private String descripcion;

	public DatoVehiculo() {
	}

	public DatoVehiculo(String n_matricula, String marca, String modelo, String descripcion) {
		this.n_matricula = n_matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.descripcion = descripcion;
	}

	public String getN_matricula() {
		return n_matricula;
	}

	public void setN_matricula(String n_matricula) {
		this.n_matricula = n_matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
