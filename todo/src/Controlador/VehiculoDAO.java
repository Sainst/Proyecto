package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.DatoVehiculo;

public class VehiculoDAO {
	private String url = "jdbc:postgresql://localhost:5432/PremiumCar";
	private String user = "Saul";
	private String pwd = "Aishiteru1234";

	public VehiculoDAO() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List findAllVeh() {
		Statement stmt = null;
		Connection conn = null;
		List allVehiculos = new ArrayList();
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from vehiculo");

			// fetch all events from database
			DatoVehiculo vhc;
			while (rs.next()) {
				vhc = new DatoVehiculo();
				vhc.setN_matricula(rs.getString(1));
				vhc.setMarca(rs.getString(2));
				vhc.setModelo(rs.getString(3));
				vhc.setDescripcion(rs.getString(4));
				allVehiculos.add(vhc);
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
		return allVehiculos;
	}

	public boolean delete(DatoVehiculo vhc) {
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("delete from vehiculo where n_matricula = '" + vhc.getN_matricula() + "'") > 0)
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

	public boolean insert(DatoVehiculo vhc) {
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			if (stmt.executeUpdate("insert into vehiculo values ('" + vhc.getN_matricula() + "','" + vhc.getMarca()
					+ "','" + vhc.getModelo() + "','" + vhc.getDescripcion() + "')") > 0)
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

	public boolean update(DatoVehiculo vhc) {
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		try {
			// get connection
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();

			if (stmt.executeUpdate("update vehiculo set n_matricula= '" + vhc.getN_matricula() + "', marca = '"
					+ vhc.getMarca() + "', modelo= '" + vhc.getModelo() + "', descripcion = '" + vhc.getDescripcion()
					+ "' where n_matricula= '" + vhc.getN_matricula() + "'") > 0)
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