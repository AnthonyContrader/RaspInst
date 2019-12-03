package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.FormatoConverter;
import it.contrader.dao.FormatoRepository;
import it.contrader.dto.FormatoDTO;
import it.contrader.model.Formato;

@Service
public class FormatoService extends AbstractService<Formato, FormatoDTO> {

	@Autowired
	private FormatoConverter converter;
	@Autowired
	private FormatoRepository repository;

}