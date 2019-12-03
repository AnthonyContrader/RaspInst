package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.PrezzoConverter;
import it.contrader.dao.PrezzoRepository;
import it.contrader.dto.PrezzoDTO;
import it.contrader.model.Prezzo;

@Service
public class PrezzoService extends AbstractService<Prezzo, PrezzoDTO> {

	@Autowired
	private PrezzoConverter converter;
	@Autowired
	private PrezzoRepository repository;

}