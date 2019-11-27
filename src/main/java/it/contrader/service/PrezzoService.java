package it.contrader.service;

import java.util.List;

import it.contrader.converter.PrezzoConverter;
import it.contrader.dao.PrezzoDAO;
import it.contrader.dto.PrezzoDTO;
import it.contrader.model.Prezzo;

public class PrezzoService extends AbstractService<Prezzo, PrezzoDTO>{
	private PrezzoDAO prezzoDAO;
	private PrezzoConverter prezzoConverter;
	
	public PrezzoService(){
		this.prezzoDAO = new PrezzoDAO();
		this.prezzoConverter = new PrezzoConverter();
	}
	
}
