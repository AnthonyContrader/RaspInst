package it.contrader.service;

import java.util.List;

import it.contrader.converter.EnvironmentConverter;
import it.contrader.dao.EnvironmentDAO;
import it.contrader.dto.EnvironmentDTO;

public class EnvironmentService {
	
	private EnvironmentDAO environmentDAO;
	private EnvironmentConverter environmentConverter;
	
	public EnvironmentService(){
		this.environmentDAO = new EnvironmentDAO();
		this.environmentConverter = new EnvironmentConverter();
	}
	

	public List<EnvironmentDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return environmentConverter.toDTOList(environmentDAO.getAll());
	}


	public EnvironmentDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return environmentConverter.toDTO(environmentDAO.read(id));
	}


	public boolean insert(EnvironmentDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return environmentDAO.insert(environmentConverter.toEntity(dto));
	}


	public boolean update(EnvironmentDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return environmentDAO.update(environmentConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo metodo chiama direttamente il DAO
		return environmentDAO.delete(id);
	}
}
