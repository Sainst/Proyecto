package Modelo;

public class DatoCargo {
	private String id_cargo;
	private String cargo;
	
	public DatoCargo(){
		
	}
	
	public DatoCargo(String id_cargo, String cargo){
		this.id_cargo = id_cargo;
		this.cargo = cargo;
	}	

	public String getId_cargo() {
		return id_cargo;
	}
	public void setId_cargo(String id_cargo) {
		this.id_cargo = id_cargo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
