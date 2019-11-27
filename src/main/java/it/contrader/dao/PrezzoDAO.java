package it.contrader.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Prezzo;

public class PrezzoDAO implements DAO<Prezzo>{
	private final String QUERY_ALL = "SELECT * FROM prezzo";
	private final String QUERY_CREATE = "INSERT INTO prezzo (costo) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM prezzo WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE prezzo SET costo=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM prezzo WHERE id=?";

	public PrezzoDAO() {
		
	}
	public List<Prezzo> getAll() {
		List<Prezzo> prezziList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Prezzo prezzo;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				float costo = resultSet.getFloat("costo");
				prezzo = new Prezzo(costo);
				prezzo.setId(id);
				prezziList.add(prezzo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prezziList;
	}
	public boolean insert(Prezzo prezzoToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setFloat(1, prezzoToInsert.getCosto());
			preparedStatement.execute();
			return true;
		} 
		catch (SQLException e) {
			return false;
		}

	}
	public Prezzo read(int prezzoId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, prezzoId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			float costo;

			costo = resultSet.getFloat("costo");
			Prezzo prezzo = new Prezzo(costo);
			prezzo.setId(resultSet.getInt("id"));

			return prezzo;
		} 
		catch (SQLException e) {
			return null;
		}

	}
	public boolean update(Prezzo prezzoToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (prezzoToUpdate.getId() == 0)
			return false;

		Prezzo prezzoRead = read(prezzoToUpdate.getId());
		if (!prezzoRead.equals(prezzoToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (prezzoToUpdate.getCosto() == 0) {
					prezzoToUpdate.setCosto(prezzoRead.getCosto());
				}
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setFloat(1, prezzoToUpdate.getCosto());
				preparedStatement.setInt(2, prezzoToUpdate.getId());
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
