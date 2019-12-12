package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.EnvironmentConverter;
import it.contrader.dao.EnvironmentRepository;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.model.Environment;

@Service
public class EnvironmentService extends AbstractService<Environment, EnvironmentDTO> {

	@Autowired
	private EnvironmentConverter converter;
	@Autowired
	private EnvironmentRepository repository;

	//public EnvironmentDTO findByNome(String nome) {
	//	return converter.toDTO(repository.findByNome(nome));
	//}
}