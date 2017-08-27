package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Modelo.DatoFrecuence;

public class Frecuence {
	private String url = "jdbc:postgresql://localhost:5432/PremiumCar";
	private String user = "Saul";
	private String pwd = "Aishiteru1234";

	public Frecuence() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public List findAllFrecuence(){
		Statement stmt = null;
		Connection conn = null;
		List allFrecuences = new ArrayList();
		try{
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from pagos");
			
			DatoFrecuence frc;
			while (rs.next()) {
				frc = new DatoFrecuence();
				frc.setId_pago(rs.getString(1));
				frc.setN_cedula_tax(rs.getString(2));
				frc.setFecha(rs.getString(3));
				frc.setEstado(rs.getString(4));
				frc.setValor_cancelado(rs.getInt(5));
				allFrecuences.add(frc);
			}
		}catch (SQLException e) {
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
		return allFrecuences;
	}
	public boolean insert(DatoFrecuence frc){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("insert into pagos values ('" + frc.getId_pago()+ "','" + frc.getN_cedula_tax() +
					"','" + frc.getFecha()+"','" + frc.getEstado() +"'," + frc.getValor_cancelado()+")") > 0);
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
	
	public boolean update(DatoFrecuence frc){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
		    stmt = conn.createStatement();				
		    
			if (stmt.executeUpdate("update pagos set id_pago= '"+ frc.getId_pago()+"', n_cedula_tax= '" + frc.getN_cedula_tax() +
					"', fecha= '" + frc.getFecha() +"', estado= '" + frc.getEstado() + "', valor_cancelado= " + frc.getValor_cancelado() +" where id_pago= '" + frc.getId_pago() + "'") > 0);
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
