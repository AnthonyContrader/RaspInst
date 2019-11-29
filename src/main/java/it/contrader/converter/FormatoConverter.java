package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.FormatoDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Formato;
import it.contrader.model.User;

public class FormatoConverter implements Converter<Formato, FormatoDTO> { 
	
	public FormatoDTO toDTO(Formato formato) {
		FormatoDTO formatodto= new FormatoDTO(formato.getId(),formato.getTipoFormato());
		return formatodto;
	}
	public Formato toEntity(FormatoDTO formatodto) {
		
		Formato formato = new Formato(formatodto.getId(),formatodto.getTipoFormato());
				return formato;
	}
	public List<FormatoDTO> toDTOList(List<Formato> formatoList){
		
		   List<FormatoDTO> formatodtolist = new ArrayList<FormatoDTO>();
			
		   for(Formato formato :formatoList )
			   formatodtolist.add(toDTO(formato));
		
		   return formatodtolist;
		
	}
}
