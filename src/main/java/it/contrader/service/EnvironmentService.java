package it.contrader.service;

import java.util.List;

import it.contrader.converter.EnvironmentConverter;
import it.contrader.dao.EnvironmentDAO;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.model.Environment;

public class EnvironmentService extends AbstractService<Environment, EnvironmentDTO> {
	
	private EnvironmentDAO environmentDAO;
	private EnvironmentConverter environmentConverter;
	
	public EnvironmentService(){
		this.environmentDAO = new EnvironmentDAO();
		this.environmentConverter = new EnvironmentConverter();
	}	
}
