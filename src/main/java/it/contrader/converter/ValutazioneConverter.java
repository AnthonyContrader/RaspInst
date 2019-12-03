package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ValutazioneDTO;
import it.contrader.model.Valutazione;

@Component
public class ValutazioneConverter extends AbstractConverter<Valutazione, ValutazioneDTO> {

	@Override
	public Valutazione toEntity(ValutazioneDTO valutazioneDTO) {
		Valutazione valutazione = null;
		if (valutazioneDTO != null) {
			valutazione = new Valutazione(valutazioneDTO.getId(), valutazioneDTO.getVoto(), valutazioneDTO.getMediaVoto());
		}
		return valutazione;
	}
	
	@Override
	public ValutazioneDTO toDTO(Valutazione valutazione) {
		ValutazioneDTO valutazioneDTO = null;
		if (valutazione != null) {
			valutazioneDTO = new ValutazioneDTO(valutazione.getId(), valutazione.getVoto(), valutazione.getMediaVoto());
		}
		return valutazioneDTO;
	}
}
