package it.contrader.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.PrezzoDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.UserService;
import it.contrader.service.PrezzoService;

public class PrezzoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public PrezzoServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<PrezzoDTO> service = new PrezzoService();
		List<PrezzoDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<PrezzoDTO> service = new PrezzoService();
		String mode = request.getParameter("mode");
		PrezzoDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "PREZZOLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/prezzo/prezzomanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/prezzo/readprezzo.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/prezzo/updateprezzo.jsp").forward(request, response);
			
			break;

		case "INSERT":
			float costo = Float.parseFloat(request.getParameter("costo"));
			dto = new PrezzoDTO (costo);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/prezzo/prezzomanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			costo =Float.parseFloat( request.getParameter("costo"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new PrezzoDTO (id,costo);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/prezzo/prezzomanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/prezzo/prezzomanager.jsp").forward(request, response);
			break;
		}
	}
}
