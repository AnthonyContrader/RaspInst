package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.FormatoDTO;

@RestController
@RequestMapping("/formato")
@CrossOrigin(origins = "http://localhost:4200")
public class FormatoController extends AbstractController<FormatoDTO> {


}
