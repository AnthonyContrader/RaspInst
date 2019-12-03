package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Valutazione;
import it.contrader.model.Valutazione.Voto;


@Repository
@Transactional

public interface ValutazioneRepository extends CrudRepository<Valutazione, Long> {
	
	Valutazione findByVotoAndMediaVoto(Voto voto, float mediaVoto);

}
