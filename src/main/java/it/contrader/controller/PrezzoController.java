package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.PrezzoDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User.Usertype;
import it.contrader.service.PrezzoService;
import it.contrader.service.UserService;

@Controller
@RequestMapping("/prezzo")
public class PrezzoController {
	
	@Autowired
	private PrezzoService service;

	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);//get o set?
		return "prezzo";
	}
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "prezzo";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateprezzo";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("costo") float costo) {
		
		PrezzoDTO dto = new PrezzoDTO();
		dto.setId(id);
		dto.setCosto(costo);
		service.update(dto);
		setAll(request);
		return "prezzi";
	}
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("costo") float costo) {
		PrezzoDTO dto = new PrezzoDTO();
		dto.setCosto(costo);
		service.insert(dto);
		setAll(request);
		return "prezzi";
	}
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readprezzo";
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
