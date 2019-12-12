package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ValutazioneDTO;
import it.contrader.model.Valutazione;

@Component
public class ValutazioneConverter extends AbstractConverter<Valutazione, ValutazioneDTO> {

	
	@Override
	public Valutazione toEntity(ValutazioneDTO valutazioneDTO) {
		Valutazione	valutazione = null;
	if (valutazioneDTO != null) { 
		valutazione = new Valutazione();
		valutazione.setId(valutazioneDTO.getId());
		if (valutazioneDTO.getVoto()!=null)
			valutazione.setVoto(valutazioneDTO.getVoto());
		//if (valutazioneDTO.getMediaVoto()!=0)
			valutazione.setMediaVoto(valutazioneDTO.getMediaVoto());
	}

		return valutazione;
	}
	
	@Override
	public ValutazioneDTO toDTO(Valutazione valutazione) {
		ValutazioneDTO valutazioneDTO = null;
		//if(valutazione.getId()!=null ) 
			valutazioneDTO= new ValutazioneDTO();
			valutazioneDTO.setId(valutazione.getId());
			if (valutazione.getVoto()!=null)
				valutazioneDTO.setVoto(valutazione.getVoto());
			if (valutazione.getMediaVoto()!=0)
				valutazioneDTO.setMediaVoto(valutazione.getMediaVoto());
			return valutazioneDTO;
	}
}
