package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.FormatoDTO;
import it.contrader.service.FormatoService;

@Controller
@RequestMapping("/formato")
public class FormatoController {

	@Autowired
	private FormatoService service;

	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "formati";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "formati";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateformato";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("tipoformato") String tipoFormato){

		FormatoDTO dto = new FormatoDTO();
		dto.setId(id);
		dto.setTipoFormato(tipoFormato);
		service.update(dto);
		setAll(request);
		return "formati";
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("tipoformato") String tipoFormato) {
		FormatoDTO dto = new FormatoDTO();
		dto.setTipoFormato(tipoFormato);
		service.insert(dto);
		setAll(request);
		return "formati";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readformato";
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
