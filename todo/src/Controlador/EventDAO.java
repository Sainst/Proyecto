package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
//import java.util.UUID;

import Modelo.TodoEvent;


public class EventDAO {
	private String url = "jdbc:postgresql://localhost:5432/PremiumCar";
	private String user = "Saul";
	private String pwd = "Aishiteru1234";

	public EventDAO() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List findAll(){
		Statement stmt = null;
		Connection conn = null;
		List allEvents = new ArrayList();
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from taxista");

			// fetch all events from database
			TodoEvent evt;
			while (rs.next()) {
				evt = new TodoEvent();
				evt.setN_cedula_tax(rs.getString(1));
				evt.setN_matricula(rs.getString(2));	
		        evt.setNombres(rs.getString(3));
				evt.setApellidos(rs.getString(4));
				evt.setLicencia(rs.getInt(5));
				evt.setDireccion(rs.getString(6));
				evt.setTelefono(rs.getString(7));
				evt.setFecha_nacimiento(rs.getString(8));					
				allEvents.add(evt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return allEvents;
	}
	
	public boolean delete(TodoEvent evt){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate(
					"delete from taxista where n_cedula_tax = '" + evt.getN_cedula_tax() + 
					"'") > 0);
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean insert(TodoEvent evt){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("insert into taxista values ('" + evt.getN_cedula_tax()+ 
					"','" + evt.getN_matricula() +"','" + evt.getNombres() +
					"','" + evt.getApellidos()+ "'," + evt.getLicencia() +
					",'" + evt.getDireccion() +"','"+ evt.getTelefono() + 
					"','" + evt.getFecha_nacimiento() +"')") > 0);
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean update(TodoEvent evt){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
		    stmt = conn.createStatement();				
		    
			if (stmt.executeUpdate("update taxista set n_cedula_tax = '"+evt.getN_cedula_tax()+ 
					"', n_matricula = '" + evt.getN_matricula() + 
					"', nombres = '" + evt.getNombres() + "', apellidos = '" + evt.getApellidos() +
					"', licencia = " + evt.getLicencia() + ", direccion = '" + evt.getDireccion() + 
					"', telefono = '" + evt.getTelefono() + 
					"', fecha_nacimiento = '" + evt.getFecha_nacimiento()+ 
					"' where n_cedula_tax = '" + evt.getN_cedula_tax() + 
					"'") > 0);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
