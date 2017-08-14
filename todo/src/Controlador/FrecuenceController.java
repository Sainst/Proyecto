package Controlador;

import java.util.List;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;

import Modelo.DatoFrecuence;

public class FrecuenceController extends GenericForwardComposer{
	Frecuence freqdao = new Frecuence();
	DatoFrecuence datofrc = new DatoFrecuence();
	Listbox box;
	

	public DatoFrecuence getDatofrc() {
		return datofrc;
	}
	public void setDatofrc(DatoFrecuence datofrc) {
		this.datofrc = datofrc;
	}
	
	public List getAllFrecuences() {
		return freqdao.findAllFrecuence();
	}	
	public void onClick$add() {		
		// insert into database		
		DatoFrecuence newFrc = new DatoFrecuence(datofrc.getId_pago(), datofrc.getN_cedula_tax(), datofrc.getFecha(), datofrc.getEstado(), datofrc.getValor_cancelado());
		freqdao.insert(newFrc);		
	}	
	public void onClick$update() {		
		if (box.getSelectedItem() != null) {
			// update database
			freqdao.update((DatoFrecuence) box.getSelectedItem().getValue());
		}
	}
//	public void onClick$delete() {		
//		if (box.getSelectedItem() != null) {
//			freqdao.delete((DatoFrecuence) box.getSelectedItem().getValue());
//		}
//	}
}
