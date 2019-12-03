package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import it.contrader.converter.ValutazioneConverter;
import it.contrader.dao.ValutazioneRepository;
import it.contrader.dto.ValutazioneDTO;
import it.contrader.model.Valutazione;
import it.contrader.model.Valutazione.Voto;

@Service
public class ValutazioneService extends AbstractService<Valutazione, ValutazioneDTO> {
	
	@Autowired
	private ValutazioneConverter converter;
	@Autowired
	private ValutazioneRepository repository;

	public ValutazioneDTO findByVotoAndMediaVoto(Voto voto, float mediaVoto) {
		return converter.toDTO(repository.findByVotoAndMediaVoto(voto, mediaVoto));
	}
}
