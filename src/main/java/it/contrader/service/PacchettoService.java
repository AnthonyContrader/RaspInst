package it.contrader.service;

import java.util.List;
import it.contrader.converter.PacchettoConverter;
import it.contrader.dao.PacchettoDAO;
import it.contrader.dto.PacchettoDTO;
import it.contrader.model.Pacchetto;

public class PacchettoService extends AbstractService<Pacchetto, PacchettoDTO>{
	private PacchettoDAO pacchettoDAO;
	private PacchettoConverter pacchettoConverter;
	
	//Istanzio DAO  e Converter specifici.
	public PacchettoService(){
		this.pacchettoDAO = new PacchettoDAO();
		this.pacchettoConverter = new PacchettoConverter();
	}
}
