package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PacchettoDTO;

@RestController
@RequestMapping("/pacchetto")
@CrossOrigin(origins = "http://localhost:4200")
public class PacchettoController extends AbstractController<PacchettoDTO>{
	
	
}
