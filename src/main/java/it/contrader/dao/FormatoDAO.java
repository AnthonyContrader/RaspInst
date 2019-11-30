package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Formato;


public class FormatoDAO implements DAO<Formato>{
	private final String QUERY_ALL = "SELECT * FROM formato";
	private final String QUERY_CREATE = "INSERT INTO formato (tipoFormato) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM formato WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE formato SET tipoFormato=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM formato WHERE id=?";

	public FormatoDAO() {
		
	}
	public List<Formato> getAll() {
		List<Formato> formatiList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Formato formato;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String tipoFormato = resultSet.getString("tipoFormato");
				formato = new Formato(tipoFormato);
				formato.setId(id);
				formatiList.add(formato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return formatiList;
	}
	public boolean insert(Formato formatoToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, formatoToInsert.getTipoFormato());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	public Formato read(int formatoId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, formatoId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String tipoFormato;

			tipoFormato = resultSet.getString("tipoFormato");
			Formato formato = new Formato(tipoFormato);
			formato.setId(resultSet.getInt("id"));

			return formato;
		} catch (SQLException e) {
			return null;
		}

	}
	public boolean update(Formato formatoToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (formatoToUpdate.getId() == 0)
			return false;

		Formato formatoRead = read(formatoToUpdate.getId());
		if (!formatoRead.equals(formatoToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (formatoToUpdate.getTipoFormato() == null || formatoToUpdate.getTipoFormato().equals("")) {
					formatoToUpdate.setTipoFormato(formatoRead.getTipoFormato());
				}
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, formatoToUpdate.getTipoFormato());
				preparedStatement.setInt(2, formatoToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
}
