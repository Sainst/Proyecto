package Controlador;

import java.util.*;
//import java.util.UUID;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import Modelo.DatoAdministrador;

public class AdministradorController extends GenericForwardComposer{
	AdministradorDAO admdao = new AdministradorDAO();
	DatoAdministrador current = new DatoAdministrador();
	Listbox box;
	
	public DatoAdministrador getCurrent() {
		return current;
	}
	public void setCurrent(DatoAdministrador current) {
		this.current = current;
	}
	public List getAllAdministradores(){
		return admdao.findAll();
	}
//	public List getAllGSS(){
//		return admdao.findAllGS();
//	}
	
	public void onClick$add() {		
		DatoAdministrador newAdm = new DatoAdministrador(current.getN_cedula_admi(), current.getId_cargo(), 
				current.getAbr_estado(), current.getNombres(), current.getApellidos(), current.getFecha_nacimiento(),
				current.getTelefono(), current.getEmail(), current.getTipo_sangre());
		admdao.insert(newAdm);		
	}	
	public void onClick$update() {		
		if (box.getSelectedItem() != null) {
			admdao.update((DatoAdministrador) box.getSelectedItem().getValue());
		}
	}
	public void onClick$delete() {		
		if (box.getSelectedItem() != null) {
			admdao.delete((DatoAdministrador) box.getSelectedItem().getValue());
		}
	}
	
}
