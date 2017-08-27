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

import Modelo.DatoAdministrador;

public class AdministradorDAO {
	private String url = "jdbc:postgresql://localhost:5432/PremiumCar";
	private String user = "Saul";
	private String pwd = "Aishiteru1234";
	
	public AdministradorDAO(){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List findAll(){
		Statement stmt = null;
		Connection conn = null;
		List allAdministradores = new ArrayList();
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from administracion where id_cargo IN ('SRC', 'OPR')");
			
			DatoAdministrador adm;
			while (rs.next()){
				adm = new DatoAdministrador();
				adm.setN_cedula_admi(rs.getString(1));
				adm.setId_cargo(rs.getString(2));
				adm.setAbr_estado(rs.getString(3));
				adm.setNombres(rs.getString(4));
				adm.setApellidos(rs.getString(5));
				adm.setFecha_nacimiento(rs.getString(6));
				adm.setTelefono(rs.getString(7));
				adm.setEmail(rs.getString(8));
				adm.setTipo_sangre(rs.getString(9));
				allAdministradores.add(adm);
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
		return allAdministradores;
	}
	
	public List findAllGS(){
		Statement stmt = null;
		Connection conn = null;
		List allGSS = new ArrayList();
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from administracion where id_cargo IN ('GRT', 'SCO')");
			
			DatoAdministrador gss;
			while (rs.next()){
				gss = new DatoAdministrador();
				gss.setN_cedula_admi(rs.getString(1));
				gss.setId_cargo(rs.getString(2));
				gss.setAbr_estado(rs.getString(3));
				gss.setNombres(rs.getString(4));
				gss.setApellidos(rs.getString(5));
				gss.setFecha_nacimiento(rs.getString(6));
				gss.setTelefono(rs.getString(7));
				gss.setEmail(rs.getString(8));
				gss.setTipo_sangre(rs.getString(9));
				allGSS.add(gss);
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
		return allGSS;
	}
	
	public boolean delete(DatoAdministrador adm){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate(
					"delete from administracion where n_cedula_admi = '" + adm.getN_cedula_admi() + "'") > 0);
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
	public boolean insert(DatoAdministrador adm){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("insert into administracion values ('" + adm.getN_cedula_admi() + "','"
					+ adm.getId_cargo() + "','" + adm.getAbr_estado() + "','" + adm.getNombres() + "','"
					+ adm.getApellidos() + "','" + adm.getFecha_nacimiento() + "','" + adm.getTelefono() + "','"
					+ adm.getEmail() + "','" + adm.getTipo_sangre() + "')") > 0);
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
	public boolean update(DatoAdministrador adm){
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
		    stmt = conn.createStatement();				
		    
			if (stmt.executeUpdate("update administracion set n_cedula_admi'" + adm.getN_cedula_admi()
					+ "', id_cargo = '" + adm.getId_cargo() + "', abr_estado = '" + adm.getAbr_estado()
					+ "', nombres = '" + adm.getNombres() + "', apellidos = '" + adm.getApellidos()
					+ "', fecha_nacimiento = '" + adm.getFecha_nacimiento() + "', telefono = '" + adm.getTelefono()
					+ "', email = '" + adm.getEmail() + "', tipo_sangre = '" + adm.getTipo_sangre() + "')") > 0);
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
