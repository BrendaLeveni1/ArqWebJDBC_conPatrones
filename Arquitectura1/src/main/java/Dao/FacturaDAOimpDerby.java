package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Modelo.Factura;
import util.ConnectionFactory;

public class FacturaDAOimpDerby implements FacturaDao {

	private Connection connection;

	public FacturaDAOimpDerby(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void crear_tabla() {
		try {
			// this.connection.getInstance().
			Statement stmt = this.connection.createStatement();
			String sql = "CREATE TABLE Factura ( idFactura INT, idCliente INT)";
			stmt.executeUpdate(sql);
			util.ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertar(int idFactura, int idCliente) {
		try {
			// this.connection.getInstance().
			Statement stmt = this.connection.createStatement();
			String sql = "INSERT INTO Factura (idFactura,idCliente) VALUES (" + idFactura + "," + idCliente + ");";
			stmt.executeUpdate(sql);
			util.ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
