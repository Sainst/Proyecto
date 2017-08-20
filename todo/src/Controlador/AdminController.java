package Controlador;

import java.util.List;
//import java.util.UUID;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;

import Modelo.DatoAdmin;

public class AdminController extends GenericForwardComposer{
	AdminDAO admdao = new AdminDAO();
	DatoAdmin datoad = new DatoAdmin();
	Listbox box;
	public DatoAdmin getDatoad() {
		return datoad;
	}
	public void setDatoad(DatoAdmin datoad) {
		this.datoad = datoad;
	}
	public List getAllAdmins(){
		return admdao.findAllAdmin();
	}
	public void onClick$add(){
		DatoAdmin newAdm = new DatoAdmin(datoad.getN_cedula_admi(), datoad.getId_cargo(),
				datoad.getAbr_estado(), datoad.getNombres(), datoad.getApellidos(), 
				datoad.getFecha_nacimiento(), datoad.getTelefono(), datoad.getEmail(), 
				datoad.getTipo_sangre());
		admdao.insert(newAdm);
	}
	public void onClick$update() {		
		if (box.getSelectedItem() != null) {
			admdao.update((DatoAdmin) box.getSelectedItem().getValue());
		}
	}
	public void onClick$delete() {		
		if (box.getSelectedItem() != null) {
			admdao.delete((DatoAdmin) box.getSelectedItem().getValue());
		}
	}
}
