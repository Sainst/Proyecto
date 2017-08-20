package Controlador;

import java.util.List;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import Modelo.DatoEstado;

public class EstadoController extends GenericForwardComposer {
	EstadoDAO estdao = new EstadoDAO();
	DatoEstado datoes = new DatoEstado();
	Listbox box;
	
	public DatoEstado getDatoes() {
		return datoes;
	}
	public void setDatoes(DatoEstado datoes) {
		this.datoes = datoes;
	}
	public List getAllEstados() {
		return estdao.findAllEst();
	}
	public void onClick$add() {
		// insert into database
		DatoEstado newEst = new DatoEstado(datoes.getAbr_estado(), datoes.getEstado());
		estdao.insert(newEst);
	}
	public void onClick$update() {
		if (box.getSelectedItem() != null) {
			// update database
			estdao.update((DatoEstado) box.getSelectedItem().getValue());
		}
	}
}
