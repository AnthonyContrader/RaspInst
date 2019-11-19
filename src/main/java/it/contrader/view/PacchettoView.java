package it.contrader.view;
import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.PacchettoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.PacchettoService;


public class PacchettoView extends AbstractView{
	private Request request;
	private String choice;
	private PacchettoService ps;
	public PacchettoView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Pacchetto ----------------\n");
			System.out.println("ID\tNome\tCategoria\tData\tVersione");
			System.out.println("----------------------------------------------------\n");
			
			List<PacchettoDTO> pacchetti = ps.getAll();
			
			//@SuppressWarnings("unchecked")
			//List<PacchettoDTO> pacchetti=(List<PacchettoDTO>) request.get("pacchetti");
			for (PacchettoDTO u: pacchetti)
				System.out.println(u);
			System.out.println();
		}
	}
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		this.choice = getInput();
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Pacchetto", "doControl", this.request);
	}
}
