package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Modelo.DatoAdmin;

public class AdminDAO {
	private String url = "jdbc:postgresql://localhost:5432/PremiumCar";
	private String user = "Saul";
	private String pwd = "Aishiteru1234";

	public AdminDAO() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List findAllAdmin() {
		Statement stmt = null;
		Connection conn = null;
		List allAdmins = new ArrayList();
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from vehiculo");

			// fetch all events from database
			DatoAdmin adm;
			while (rs.next()) {
				adm = new DatoAdmin();
				adm.setN_cedula_admi(rs.getString(1));
				adm.setId_cargo(rs.getString(2));
				adm.setAbr_estado(rs.getString(3));
				adm.setNombres(rs.getString(4));
				adm.setApellidos(rs.getString(5));
				adm.setFecha_nacimiento(rs.getString(6));
				adm.setTelefono(rs.getString(7));
				adm.setEmail(rs.getString(8));
				adm.setTipo_sangre(rs.getString(9));
				allAdmins.add(adm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return allAdmins;
	}

	public boolean delete(DatoAdmin admin) {
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate(
					"delete from administracion where n_cedula_admi = '" + admin.getN_cedula_admi() + "'") > 0)
				;
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	public boolean insert(DatoAdmin admin) {
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("insert into administracion values ('" + admin.getN_cedula_admi() + "','"
					+ admin.getId_cargo() + "','" + admin.getAbr_estado() + "','" + admin.getNombres() + "','"
					+ admin.getApellidos() + "','" + admin.getFecha_nacimiento() + "','" + admin.getTelefono() + "','"
					+ admin.getEmail() + "','" + admin.getTipo_sangre() + "')") > 0)
				;
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	public boolean update(DatoAdmin admin) {
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("update administracion set n_cedula_admi'" + admin.getN_cedula_admi()
					+ "', id_cargo = '" + admin.getId_cargo() + "', abr_estado = '" + admin.getAbr_estado()
					+ "', nombres = '" + admin.getNombres() + "', apellidos = '" + admin.getApellidos()
					+ "', fecha_nacimiento = '" + admin.getFecha_nacimiento() + "', telefono = '" + admin.getTelefono()
					+ "', email = '" + admin.getEmail() + "', tipo_sangre = '" + admin.getTipo_sangre() + "')") > 0)
				;
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
