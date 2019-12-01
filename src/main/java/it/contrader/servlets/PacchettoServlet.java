package it.contrader.servlets;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.PacchettoDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.PacchettoService;
import it.contrader.service.Service;
public class PacchettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PacchettoServlet() {
	
	}
	public void updateList(HttpServletRequest request) {
		Service<PacchettoDTO> service = new PacchettoService();
		List<PacchettoDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<PacchettoDTO> service = new PacchettoService();
		String mode = request.getParameter("mode");
		PacchettoDTO dto;
		int id;
		boolean ans;
		final HttpSession session = request.getSession();
	//	@SuppressWarnings("unused")
		UserDTO u=(UserDTO)session.getAttribute("user");


		switch (mode.toUpperCase()) {

		case "PACCHETTOLIST":
			if(u.getUsertype().equals("ADMIN")) {
			updateList(request);
			getServletContext().getRequestDispatcher("/pacchetto/pacchettomanager.jsp").forward(request, response);
			}
			if(u.getUsertype().equals("USER")) {
				updateList(request);
				getServletContext().getRequestDispatcher("/userpacchetto/userpacchettomanager.jsp").forward(request, response);
			}
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/pacchetto/readpacchetto.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/pacchetto/updatepacchetto.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String nome = request.getParameter("nome").toString();
			String categoria = request.getParameter("categoria").toString();
			String versione = request.getParameter("versione").toString();
			String data = request.getParameter("data").toString();
			dto = new PacchettoDTO (nome,categoria,versione,data);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/pacchetto/pacchettomanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			nome= request.getParameter("nome");
			categoria = request.getParameter("categoria");
			versione = request.getParameter("versione");
			data = request.getParameter("data");

			id = Integer.parseInt(request.getParameter("id"));
			dto = new PacchettoDTO (id,nome, categoria, versione, data);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/pacchetto/pacchettomanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/pacchetto/pacchettomanager.jsp").forward(request, response);
			break;
		}
	}
}

