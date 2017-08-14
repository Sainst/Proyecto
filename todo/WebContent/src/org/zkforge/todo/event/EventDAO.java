package org.zkforge.todo.event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class EventDAO {
	private String url = "jdbc:hsqldb:file:/hsqldb/event";

	private String user = "sa";

	private String pwd = "";

	public EventDAO() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
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
			ResultSet rs = stmt.executeQuery("select * from event");

			// fetch all events from database
			Event evt;
			while (rs.next()) {
				evt = new Event();
				evt.setId(rs.getString(1));
		        evt.setName(rs.getString(2));
				evt.setPriority(rs.getInt(3));
				evt.setDate(rs.getDate(4));

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
	
	public boolean delete(Event evt){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("delete from event where id = '" + evt.getId() + "'") > 0);
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
	
	public boolean insert(Event evt){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("insert into event(id,name,priority,date) " +
					"values ('" + UUID.randomUUID().toString() + "','" + evt.getName() +
					"'," + evt.getPriority() + ",'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(evt.getDate()) + "')") > 0);
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
	
	public boolean update(Event evt){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
		    stmt = conn.createStatement();				
			if (stmt.executeUpdate("update event set name = '" + evt.getName() + 
					"', priority = " + evt.getPriority() + ", date = '" + 
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(evt.getDate())+ 
					"' where id = '" + evt.getId() + "'") > 0);
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
