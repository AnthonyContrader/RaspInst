package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.PacchettoDTO;
import it.contrader.service.PacchettoService;


@Controller
@RequestMapping("/pacchetto")
public class PacchettoController {
	
	@Autowired
	private PacchettoService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request); //set o get??
		return "pacchetti";
	}
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatePacchetto";
	}
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("nome") String nome,
			@RequestParam("categoria") String categoria, @RequestParam("versione") String versione) {

		PacchettoDTO dto = new PacchettoDTO();
		dto.setId(id);
		dto.setNome(nome);
		dto.setCategoria(categoria);
		dto.setVersione(versione);
		service.update(dto);
		setAll(request); //set o get?
		return "pacchetti";
	}
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("nome") String nome,
			@RequestParam("categoria") String categoria, @RequestParam("versione") String versione) {
		PacchettoDTO dto = new PacchettoDTO();
		dto.setNome(nome);
		dto.setCategoria(categoria);
		dto.setVersione(versione);
		service.insert(dto);
		setAll(request);
		return "pacchetti";
	}
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readpacchetto";
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
