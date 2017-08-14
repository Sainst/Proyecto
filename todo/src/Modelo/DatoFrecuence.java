package Modelo;

public class DatoFrecuence {
	private String id_pago;
	private String n_cedula_tax;
	private String fecha;
	private String estado;
	private int valor_cancelado;

	public DatoFrecuence() {
	}

	public DatoFrecuence(String id_pago, String n_cedula_tax, String fecha, String estado, int valor_cancelado) {
		this.id_pago = id_pago;
		this.n_cedula_tax = n_cedula_tax;
		this.fecha = fecha;
		this.estado = estado;
		this.valor_cancelado = valor_cancelado;
	}

	public String getId_pago() {
		return id_pago;
	}

	public void setId_pago(String id_pago) {
		this.id_pago = id_pago;
	}

	public String getN_cedula_tax() {
		return n_cedula_tax;
	}

	public void setN_cedula_tax(String n_cedula_tax) {
		this.n_cedula_tax = n_cedula_tax;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getValor_cancelado() {
		return valor_cancelado;
	}

	public void setValor_cancelado(int valor_cancelado) {
		this.valor_cancelado = valor_cancelado;
	}

}
