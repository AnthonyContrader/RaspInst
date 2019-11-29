package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Pacchetto;


public class PacchettoDAO implements DAO<Pacchetto> {
	 

	private final String QUERY_ALL = "SELECT * FROM pacchetto";
	private final String QUERY_CREATE = "INSERT INTO pacchetto (nome, categoria, versione, data) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM pacchetto WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE pacchetto SET nome=?, categoria=?, versione=?, data=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM pacchetto WHERE id=?";
	
	public PacchettoDAO() {
	
	}  
	public List<Pacchetto> getAll() {
		List<Pacchetto> pacchettiList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Pacchetto pacchetto;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String categoria = resultSet.getString("categoria");
				String versione = resultSet.getString("versione");
				String data= resultSet.getString("data");
				pacchetto = new Pacchetto(nome, categoria, versione,data);
				pacchetto.setId(id);
				pacchettiList.add(pacchetto);
			}
		}
			 catch (SQLException e) {
				 e.printStackTrace();
			 }
			return pacchettiList;
		}
	public boolean insert(Pacchetto pacchettoToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, pacchettoToInsert.getNome());
			preparedStatement.setString(2, pacchettoToInsert.getCategoria());
			preparedStatement.setString(3, pacchettoToInsert.getVersione());
			preparedStatement.setString(4, pacchettoToInsert.getData());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
			}

	}
	public Pacchetto read(int pacchettoId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, pacchettoId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nome, categoria, versione,data;
			nome = resultSet.getString("nome");
			categoria = resultSet.getString("categoria");
			versione = resultSet.getString("versione");
			data=resultSet.getString("data");
			Pacchetto pacchetto= new Pacchetto(nome, categoria, versione,data);
			pacchetto.setId(resultSet.getInt("id"));
			return pacchetto;
		} 
		catch (SQLException e) {
			return null;
		}
	}
	public boolean update(Pacchetto pacchettoToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (pacchettoToUpdate.getId() == 0)
			return false;

		Pacchetto pacchettoRead = read(pacchettoToUpdate.getId());
		if (!pacchettoRead.equals(pacchettoToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (pacchettoToUpdate.getNome() == null || pacchettoToUpdate.getNome().equals("")) {
					pacchettoToUpdate.setNome(pacchettoRead.getNome());
				}

				if (pacchettoToUpdate.getCategoria() == null || pacchettoToUpdate.getCategoria().equals("")) {
					pacchettoToUpdate.setCategoria(pacchettoRead.getCategoria());
				}

				if (pacchettoToUpdate.getVersione() == null || pacchettoToUpdate.getVersione().equals("")) {
					pacchettoToUpdate.setVersione(pacchettoRead.getVersione());
				}

				// Update the pacchetto
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, pacchettoToUpdate.getNome());
				preparedStatement.setString(2, pacchettoToUpdate.getCategoria());
				preparedStatement.setString(3, pacchettoToUpdate.getVersione());
				preparedStatement.setString(4, pacchettoToUpdate.getData());
				preparedStatement.setInt(5, pacchettoToUpdate.getId());
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
