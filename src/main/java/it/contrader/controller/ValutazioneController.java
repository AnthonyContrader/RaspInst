package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ValutazioneDTO;
import it.contrader.model.Valutazione;
import it.contrader.model.Valutazione.Voto;
import it.contrader.service.ValutazioneService;

@Controller
@RequestMapping("/valutazione")

public class ValutazioneController {

	@Autowired
	private ValutazioneService service;

	
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "valutazioni";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "valutazioni";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatevalutazioni";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("voto") Valutazione.Voto voto,
			@RequestParam("password") String password, @RequestParam("mediaVoto") float mediaVoto) {

		ValutazioneDTO dto = new ValutazioneDTO();
		dto.setId(id);
		dto.setVoto(voto);
		dto.setMediaVoto(mediaVoto);
		service.update(dto);
		setAll(request);
		return "valutazioni";

	}


	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("voto") Valutazione.Voto voto,
			@RequestParam("password") String password, @RequestParam("mediaVoto") float mediaVoto) {
		ValutazioneDTO dto = new ValutazioneDTO();
		dto.setVoto(voto);
		dto.setMediaVoto(mediaVoto);
		service.insert(dto);
		setAll(request);
		return "valutazioni";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readvalutazioni";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
