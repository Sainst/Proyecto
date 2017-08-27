package Modelo;

public class DatoEstado {
	private String abr_estado;
	private String estado;
	
	public DatoEstado(){
		
	}
	public DatoEstado(String abr_estado, String estado){
		this.abr_estado = abr_estado;
		this.estado = estado;
	}
	
	public String getAbr_estado() {
		return abr_estado;
	}
	public void setAbr_estado(String abr_estado) {
		this.abr_estado = abr_estado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
