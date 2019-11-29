package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.model.Environment;



public class EnvironmentConverter implements Converter<Environment, EnvironmentDTO>{
	@Override
	public EnvironmentDTO toDTO(Environment environment) {
		EnvironmentDTO environmentdto= new EnvironmentDTO(environment.getId(),environment.getNome());
		return environmentdto;
	}
	@Override
	public Environment toEntity(EnvironmentDTO environmentdto) {
	
		Environment environment = new Environment(environmentdto.getId(),environmentdto.getNome());
				return environment;
	}
	@Override
	public List<EnvironmentDTO> toDTOList(List<Environment> environmentList){
		
		   List<EnvironmentDTO> environmentdtolist = new ArrayList<EnvironmentDTO>();
			
		   for(Environment environment :environmentList )
			   environmentdtolist.add(toDTO(environment));
		
		   return environmentdtolist;
		
	}
}
