package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.FormatoDTO;
import it.contrader.dto.PrezzoDTO;
import it.contrader.model.Formato;
import it.contrader.model.Prezzo;

@Component
public class FormatoConverter extends AbstractConverter<Formato,FormatoDTO>{
	@Override
	public Formato toEntity(FormatoDTO formatoDTO) {
		Formato formato=null;
		if(formatoDTO!=null) {
			formato=new Formato(formatoDTO.getId(),formatoDTO.getTipoFormato());
		}
		return formato;
	}
	@Override
	public FormatoDTO toDTO(Formato formato) {
		FormatoDTO formatoDTO = null;
		if (formato != null) {
			formatoDTO = new FormatoDTO(formato.getId(), formato.getTipoFormato());
		}
		return formatoDTO;
	}
}
