package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.DatoEstado;

public class EstadoDAO {
	private String url = "jdbc:postgresql://localhost:5432/PremiumCar";
	private String user = "Saul";
	private String pwd = "Aishiteru1234";
	
	public EstadoDAO() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List findAllEst() {
		Statement stmt = null;
		Connection conn = null;
		List allEstados = new ArrayList();
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from estado");

			// fetch all events from database
			DatoEstado est;
			while (rs.next()) {
				est = new DatoEstado();
				est.setAbr_estado(rs.getString(1));
				est.setEstado(rs.getString(2));
				allEstados.add(est);
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
		return allEstados;
	}
	public boolean insert(DatoEstado est) {
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("insert into estado values ('" + est.getAbr_estado() + "','" + est.getEstado()
					+"')") > 0);
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
	public boolean update(DatoEstado est) {
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();

			if (stmt.executeUpdate("update estado set abr_estado= '" + est.getAbr_estado() + "', estado = '"
					+ est.getEstado() + "' where abr_estado= '" + est.getAbr_estado() + "'") > 0)
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
