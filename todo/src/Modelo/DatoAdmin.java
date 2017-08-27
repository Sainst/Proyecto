package Modelo;

public class DatoAdmin {
	private String n_cedula_admi;
	private String id_cargo;
	private String abr_estado;
	private String nombres;
	private String apellidos;
	private String fecha_nacimiento;
	private String telefono;
	private String email;
	private String tipo_sangre;

	public DatoAdmin() {
	}

	public DatoAdmin(String n_cedula_admi, String id_cargo, String abr_estado, String nombres, String apellidos,
			String fecha_nacimiento, String telefono, String email, String tipo_sangre) {
		this.n_cedula_admi = n_cedula_admi;
		this.id_cargo = id_cargo;
		this.abr_estado = abr_estado;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.email = email;
		this.tipo_sangre = tipo_sangre;
	}

	public String getN_cedula_admi() {
		return n_cedula_admi;
	}

	public void setN_cedula_admi(String n_cedula_admi) {
		this.n_cedula_admi = n_cedula_admi;
	}

	public String getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(String id_cargo) {
		this.id_cargo = id_cargo;
	}

	public String getAbr_estado() {
		return abr_estado;
	}

	public void setAbr_estado(String abr_estado) {
		this.abr_estado = abr_estado;
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

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo_sangre() {
		return tipo_sangre;
	}

	public void setTipo_sangre(String tipo_sangre) {
		this.tipo_sangre = tipo_sangre;
	}
}
