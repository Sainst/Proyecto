package Controlador;

import java.util.List;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import Modelo.DatoVehiculo;

public class VehiculoController extends GenericForwardComposer {
	VehiculoDAO vhcdao = new VehiculoDAO();
	DatoVehiculo datove = new DatoVehiculo();
	Listbox box;

	public DatoVehiculo getDatove() {
		return datove;
	}
	public void setDatove(DatoVehiculo datove) {
		this.datove = datove;
	}
	public List getAllVehiculos() {
		return vhcdao.findAllVeh();
	}
	public void onClick$add() {
		// insert into database
		DatoVehiculo newVhc = new DatoVehiculo(datove.getN_matricula(), datove.getMarca(), datove.getModelo(),
				datove.getDescripcion());
		vhcdao.insert(newVhc);
	}
	public void onClick$update() {
		if (box.getSelectedItem() != null) {
			// update database
			vhcdao.update((DatoVehiculo) box.getSelectedItem().getValue());
		}
	}
	public void onClick$delete() {
		if (box.getSelectedItem() != null) {
			vhcdao.delete((DatoVehiculo) box.getSelectedItem().getValue());
		}
	}
}