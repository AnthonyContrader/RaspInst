package it.contrader.service;

import java.util.List;

import it.contrader.converter.PrezzoConverter;
import it.contrader.dao.PrezzoDAO;
import it.contrader.dto.PrezzoDTO;

public class PrezzoService {
	private PrezzoDAO prezzoDAO;
	private PrezzoConverter prezzoConverter;
	
	public PrezzoService(){
		this.prezzoDAO = new PrezzoDAO();
		this.prezzoConverter = new PrezzoConverter();
	}
	public List<PrezzoDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return prezzoConverter.toDTOList(prezzoDAO.getAll());
	}
	public PrezzoDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return prezzoConverter.toDTO(prezzoDAO.read(id));
	}
	public boolean insert(PrezzoDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return prezzoDAO.insert(prezzoConverter.toEntity(dto));
	}
	public boolean update(PrezzoDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return prezzoDAO.update(prezzoConverter.toEntity(dto));
	}
	public boolean delete(int id) {
		// Questo metodo chiama direttamente il DAO
		return prezzoDAO.delete(id);
	}
}
