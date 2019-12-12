package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.model.Environment;


@Component
public class EnvironmentConverter extends AbstractConverter <Environment,EnvironmentDTO> {
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public Environment toEntity(EnvironmentDTO environmentDTO) {
		Environment environment=null;
	//if(environmentDTO!=null) {
			
			environment=new Environment();
	//		if(environmentDTO.getId()!=null ) 
			environment.setId(environmentDTO.getId());
			if (environmentDTO.getNome()!=null)
				environment.setNome(environmentDTO.getNome());
		//	if(environmentDTO.getId())
		//environment=new Environment(environmentDTO.getId(),environmentDTO.getNome());
		//}
			if(environmentDTO.getUserDTO()!=null) {
				environment.setUser(userConverter.toEntity(environmentDTO.getUserDTO()));
			}

		
		
		return environment;
	}
	
	@Override
	public EnvironmentDTO toDTO(Environment environment) {
		EnvironmentDTO environmentDTO=null;
		environmentDTO=new EnvironmentDTO();
	//if(environment.getId()!=null ) 
		environmentDTO.setId(environment.getId());
		if (environment.getNome()!=null)
			environmentDTO.setNome(environment.getNome());
		if(environment.getUser()!=null) {
			environmentDTO.setUserDTO(userConverter.toDTO(environment.getUser()));
		}
		return environmentDTO;
	}
}
