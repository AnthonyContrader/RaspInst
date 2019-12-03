package it.contrader.dao;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Prezzo;
@Repository
@Transactional
public interface PrezzoRepository extends CrudRepository<Prezzo,Long> {

}
