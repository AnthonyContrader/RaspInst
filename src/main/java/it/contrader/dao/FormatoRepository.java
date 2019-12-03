package it.contrader.dao;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Formato;
@Repository
@Transactional
public interface FormatoRepository extends CrudRepository<Formato,Long> {

	
}
