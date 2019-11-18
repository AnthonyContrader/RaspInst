package it.contrader.service;

import java.util.List;
import it.contrader.converter.PacchettoConverter;
import it.contrader.dao.PacchettoDAO;
import it.contrader.dto.PacchettoDTO;

public class PacchettoService {
	private PacchettoDAO pacchettoDAO;
	private PacchettoConverter pacchettoConverter;
	
	//Istanzio DAO  e Converter specifici.
	public PacchettoService(){
		this.pacchettoDAO = new PacchettoDAO();
		this.pacchettoConverter = new PacchettoConverter();
	}
	

	public List<PacchettoDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return pacchettoConverter.toDTOList(pacchettoDAO.getAll());
	}


	public PacchettoDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return pacchettoConverter.toDTO(pacchettoDAO.read(id));
	}


	public boolean insert(PacchettoDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return pacchettoDAO.insert(pacchettoConverter.toEntity(dto));
	}


	public boolean update(PacchettoDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return pacchettoDAO.update(pacchettoConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return pacchettoDAO.delete(id);
	}
}
