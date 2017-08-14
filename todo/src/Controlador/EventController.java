package Controlador;

/**
 * Event Controller.
 * 
 * @author robbiecheng
 */

import java.util.*;
//import java.util.UUID;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import Modelo.TodoEvent;

public class EventController extends GenericForwardComposer {
	EventDAO evtdao = new EventDAO();
	TodoEvent current = new TodoEvent();
	Listbox box;
	
	public TodoEvent getCurrent() {return current;
	}
	public void setCurrent(TodoEvent current) {this.current = current;
	}
	public List getAllEvents() {return evtdao.findAll();
	}	
	public void onClick$add() {		
		TodoEvent newEvt = new TodoEvent(current.getN_cedula_tax(), 
				current.getN_matricula(), current.getNombres(), 
				current.getApellidos(), current.getLicencia(), 
				current.getDireccion(), current.getTelefono(), 
				current.getFecha_nacimiento());
		evtdao.insert(newEvt);		
	}	
	public void onClick$update() {		
		if (box.getSelectedItem() != null) {
			evtdao.update((TodoEvent) box.getSelectedItem().getValue());
		}
	}
	public void onClick$delete() {		
		if (box.getSelectedItem() != null) {
			evtdao.delete((TodoEvent) box.getSelectedItem().getValue());
		}
	}
}
