package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;

import it.contrader.converter.PacchettoConverter;
import it.contrader.dao.PacchettoRepository;
import it.contrader.dto.PacchettoDTO;
import it.contrader.model.Pacchetto;

@Service
public class PacchettoService extends AbstractService<Pacchetto, PacchettoDTO> {
	@Autowired
	private PacchettoConverter converter;
	@Autowired
	private PacchettoRepository repository;

	public PacchettoDTO findByNome(String nome) {
		return converter.toDTO(repository.findByNome(nome));
	}
}
