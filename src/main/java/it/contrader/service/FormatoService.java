package it.contrader.service;
import it.contrader.converter.FormatoConverter;
import it.contrader.dao.FormatoDAO;
import it.contrader.dto.FormatoDTO;
import it.contrader.model.Formato;

public class FormatoService extends AbstractService<Formato, FormatoDTO>  {
	private FormatoDAO formatoDAO;
	private FormatoConverter formatoConverter;
	
	public FormatoService(){
		this.formatoDAO = new FormatoDAO();
		this.formatoConverter = new FormatoConverter();
	}
}
