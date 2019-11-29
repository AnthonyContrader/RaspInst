package it.contrader.service;
import it.contrader.converter.FormatoConverter;
import it.contrader.dao.FormatoDAO;
import it.contrader.dto.FormatoDTO;
import it.contrader.model.Formato;

public class FormatoService extends AbstractService<Formato, FormatoDTO>  {

	public FormatoService(){
		this.dao = new FormatoDAO();
		this.converter = new FormatoConverter();
	}
}
