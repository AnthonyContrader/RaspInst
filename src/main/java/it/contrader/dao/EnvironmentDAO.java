package it.contrader.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Environment;


public class EnvironmentDAO implements DAO<Environment>{
	private final String QUERY_ALL = "SELECT * FROM environment";
	private final String QUERY_CREATE = "INSERT INTO environment (nome) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM environment WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE environment SET nome=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM environment WHERE id=?";

	public EnvironmentDAO() {
		
	}
	public List<Environment> getAll() {
		List<Environment> environmentsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Environment environment;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				environment = new Environment(nome);
				environment.setId(id);
				environmentsList.add(environment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return environmentsList;
	}
	public boolean insert(Environment environmentToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, environmentToInsert.getNome());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	public Environment read(int environmentId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, environmentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nome;

			nome = resultSet.getString("nome");
			Environment environment = new Environment(nome);
			environment.setId(resultSet.getInt("id"));

			return environment;
		} catch (SQLException e) {
			return null;
		}

	}
	public boolean update (Environment environmentToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (environmentToUpdate.getId() == 0)
			return false;

		Environment environmentRead = read(environmentToUpdate.getId());
		if (!environmentRead.equals(environmentToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (environmentToUpdate.getNome() == null || environmentToUpdate.getNome().equals("")) {
					environmentToUpdate.setNome(environmentRead.getNome());
				}
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, environmentToUpdate.getNome());
				preparedStatement.setInt(2, environmentToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} 
			catch (SQLException e) {
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