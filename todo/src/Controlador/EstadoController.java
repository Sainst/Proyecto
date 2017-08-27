package Controlador;

import java.util.*;
//import java.util.UUID;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import Modelo.DatoEstado;

public class EstadoController extends GenericForwardComposer{
	EstadoDAO estdao = new EstadoDAO();
	DatoEstado current = new DatoEstado();
	Listbox box;
	
	public DatoEstado getCurrent() {
		return current;
	}
	public void setCurrent(DatoEstado current) {
		this.current = current;
	}
	public List getAllEstados(){
		return estdao.findAllEst();
	}
}
