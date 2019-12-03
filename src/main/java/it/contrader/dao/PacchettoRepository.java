package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Pacchetto;

@Repository
@Transactional
public interface PacchettoRepository extends CrudRepository<Pacchetto,Long> {

	Pacchetto findByNome(String nome);

}