package Controlador;

import java.util.*;
//import java.util.UUID;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import Modelo.DatoCargo;

public class CargoController extends GenericForwardComposer {
	CargoDAO crgdao = new CargoDAO();
	DatoCargo current = new DatoCargo();
	Listbox box;
	
	public DatoCargo getCurrent() {
		return current;
	}
	public void setCurrent(DatoCargo current) {
		this.current = current;
	}
	public List getAllCargos(){
		return crgdao.findAllCrg();
	}
}
