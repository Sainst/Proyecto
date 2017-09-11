package Modelo;

//import java.util.Date;

public class TodoEvent {
	private String n_cedula_tax;
	private String n_matricula;
	private String nombres;
	private String apellidos;
	private int licencia;
	private String direccion;
	private String telefono;
	private String fecha_nacimiento;

	public TodoEvent() {
	}

	public TodoEvent(String n_cedula_tax, String n_matricula, String nombres, String apellidos, int licencia,
			String direccion, String telefono, String fecha_nacimiento) {

		this.n_cedula_tax = n_cedula_tax;
		this.n_matricula = n_matricula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.licencia = licencia;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getN_cedula_tax() {
		return n_cedula_tax;
	}

	public void setN_cedula_tax(String n_cedula_tax) {
		this.n_cedula_tax = n_cedula_tax;
	}

	public String getN_matricula() {
		return n_matricula;
	}

	public void setN_matricula(String n_matricula) {
		this.n_matricula = n_matricula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getLicencia() {
		return licencia;
	}

	public void setLicencia(int licencia) {
		this.licencia = licencia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

}
