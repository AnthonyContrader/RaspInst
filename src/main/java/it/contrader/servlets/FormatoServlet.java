package it.contrader.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.FormatoDTO;
import it.contrader.service.Service;
import it.contrader.service.FormatoService;



public class FormatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FormatoServlet() {
	
	}
	public void updateList(HttpServletRequest request) {
		Service<FormatoDTO> service = new FormatoService();
		List<FormatoDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

@Override
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Service<FormatoDTO> service = new FormatoService();
	String mode = request.getParameter("mode");
	FormatoDTO dto;
	int id;
	boolean ans;

		switch (mode.toUpperCase()) {

		case "FORMATOLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/formato/formatomanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
		
			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/formato/readformato.jsp").forward(request, response);
			
			}
		
			else getServletContext().getRequestDispatcher("/formato/updateformato.jsp").forward(request, response);
			break;

		case "INSERT":
			String tipoFormato = request.getParameter("tipoformato").toString();
			dto = new FormatoDTO (tipoFormato);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/formato/formatomanager.jsp").forward(request, response);
			break;
		
		case "UPDATE":
			tipoFormato = request.getParameter("tipoformato").toString();
			id = Integer.parseInt(request.getParameter("id"));
			dto = new FormatoDTO (id,tipoFormato);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/formato/formatomanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/formato/formatomanager.jsp").forward(request, response);
			break;
		}
	}
}
