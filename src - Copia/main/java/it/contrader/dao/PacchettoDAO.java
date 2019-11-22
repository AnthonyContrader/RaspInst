package it.contrader.dao;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Pacchetto;
import java.util.ArrayList;
import java.sql.*;

public class PacchettoDAO {
	private final String QUERY_ALL = "SELECT * FROM Pacchetto";
	private final String QUERY_CREATE = "INSERT INTO Pacchetto (nome, categoria, data, versione) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM Pacchetto WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE Pacchetto SET nome=?, categoria=?, data=?, versione=?, WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM Pacchetto WHERE id=?";

	public PacchettoDAO() {
		
	}
	
	public List <Pacchetto> getAll(){
		List<Pacchetto> listaPacchetti=new ArrayList();
		Connection connection= ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Pacchetto pacchetto;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("name");
				String categoria = resultSet.getString("categoria");
				String data = resultSet.getString("data");
				String versione = resultSet.getString("versione");
				pacchetto = new Pacchetto(nome, categoria, data,versione);
				pacchetto.setId(id);
				listaPacchetti.add(pacchetto);
			}
		}
		catch (SQLException e) {
			return null;
		}	
		return listaPacchetti;
	}
	public boolean insert(Pacchetto pacchettoToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, pacchettoToInsert.getNome());
			preparedStatement.setString(2, pacchettoToInsert.getCategoria());
			preparedStatement.setString(3, pacchettoToInsert.getData());
			preparedStatement.setString(4, pacchettoToInsert.getVersione());
			preparedStatement.execute();
			return true;
		}
		catch (SQLException e) {
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
			String nome, categoria, data,versione;

			nome = resultSet.getString("nome");
			categoria = resultSet.getString("categoria");
			data = resultSet.getString("data");
			versione = resultSet.getString("versione");
			Pacchetto pacchetto = new Pacchetto (nome, categoria, data, versione);
			pacchetto.setId(resultSet.getInt("id"));

			return pacchetto;
		} 
		catch (SQLException e) {
			return null;
		}

	}
	public boolean update(Pacchetto pacchettoToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		if (pacchettoToUpdate.getId() == 0)
			return false;

		Pacchetto pacchettoRead = read(pacchettoToUpdate.getId());
		if (!pacchettoRead.equals(pacchettoToUpdate)) {
			try {
				if (pacchettoToUpdate.getNome() == null || pacchettoToUpdate.getNome().equals("")) {
					pacchettoToUpdate.setNome(pacchettoRead.getNome());
				}
				if (pacchettoToUpdate.getCategoria() == null || pacchettoToUpdate.getCategoria().equals("")) {
					pacchettoToUpdate.setCategoria(pacchettoRead.getCategoria());
				}

				if (pacchettoToUpdate.getData() == null || pacchettoToUpdate.getData().equals("")) {
					pacchettoToUpdate.setData(pacchettoRead.getData());
				}
				if (pacchettoToUpdate.getVersione() == null || pacchettoToUpdate.getVersione().equals("")) {
					pacchettoToUpdate.setVersione(pacchettoRead.getVersione());
				}
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, pacchettoToUpdate.getNome());
				preparedStatement.setString(2, pacchettoToUpdate.getCategoria());
				preparedStatement.setString(3, pacchettoToUpdate.getData());
				preparedStatement.setString(4, pacchettoToUpdate.getVersione());
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
