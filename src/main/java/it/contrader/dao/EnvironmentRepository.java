package it.contrader.dao;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Environment;

@Repository
@Transactional
public interface EnvironmentRepository extends CrudRepository<Environment,Long> {
	//Environment findByNome(String nome);

}
