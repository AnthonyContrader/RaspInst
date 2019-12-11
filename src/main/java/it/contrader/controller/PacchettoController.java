package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CategoryDTO;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.dto.FormatoDTO;
import it.contrader.dto.PacchettoDTO;
import it.contrader.dto.ValutazioneDTO;
import it.contrader.service.CategoryService;
import it.contrader.service.EnvironmentService;
import it.contrader.service.FormatoService;
import it.contrader.service.PacchettoService;
import it.contrader.service.ValutazioneService;


@Controller
@RequestMapping("/pacchetto")
public class PacchettoController {
	
	@Autowired
	private PacchettoService service;
	@Autowired
	private EnvironmentService environmentService;	
	@Autowired
	private FormatoService formatoService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ValutazioneService valutazioneService;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request); //set o get??
		
		return "pacchetto";
	}
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatePacchetto";
	}
	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id, 
			@RequestParam("nome") String nome,
		//	@RequestParam("categoria") String categoria, 
			@RequestParam("versione") String versione,
			@RequestParam("environment") Long idEnvironment,
			@RequestParam("formato") Long idFormato,
			@RequestParam("category") Long idCategory,
			@RequestParam("valutazione") Long idValutazione)
	{
	
		PacchettoDTO dto = new PacchettoDTO();
		EnvironmentDTO e = environmentService.read(idEnvironment);
		FormatoDTO f = formatoService.read(idFormato);
		CategoryDTO c = categoryService.read(idCategory);
		dto.setNome(nome);
	//	dto.setCategoria(categoria);
		dto.setVersione(versione);
		dto.setEnvironmentDTO(e);
		dto.setFormatoDTO(f);
		dto.setCategoryDTO(c);
		service.update(dto);
		setAll(request); 
		return "pacchetto";
	}
	@PostMapping("/insert")
	public String insert(HttpServletRequest request,
			@RequestParam("nome") String nome,
		//	@RequestParam("categoria") String categoria, 
			@RequestParam("versione") String versione,
			@RequestParam("environment") Long idEnvironment,
			@RequestParam("formato") Long idFormato,
			@RequestParam("category") Long idCategory,
			@RequestParam("valutazione") Long idValutazione	
			) {
	
		PacchettoDTO dto = new PacchettoDTO();
		EnvironmentDTO e = environmentService.read(idEnvironment);
		FormatoDTO f = formatoService.read(idFormato);
		CategoryDTO c = categoryService.read(idCategory);
		ValutazioneDTO v = valutazioneService.read(idValutazione);
		
		dto.setNome(nome);
	//	dto.setCategoria(categoria);
		dto.setVersione(versione);
		dto.setEnvironmentDTO(e);
		dto.setFormatoDTO(f);
		dto.setCategoryDTO(c);
		dto.setValutazioneDTO(v);
		
		
		service.insert(dto);
		setAll(request);
		return "pacchetto";
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
		request.getSession().setAttribute("environment", environmentService.getAll());
		request.getSession().setAttribute("formato", formatoService.getAll());
		request.getSession().setAttribute("category", categoryService.getAll());
		request.getSession().setAttribute("valutazione", valutazioneService.getAll());
	}
/*	private void setAllCategory(HttpServletRequest request) {
		request.getSession().setAttribute("category", categoryService.getAll());
	}*/
}
