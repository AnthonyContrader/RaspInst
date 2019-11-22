package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.PacchettoDTO;
import it.contrader.main.MainDispatcher;

public class PacchettoUserView  extends AbstractView{
	private Request request;
	private String choice;
	public PacchettoUserView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Pacchetto ----------------\n");
			System.out.println("ID\tNome\tCategoria\tData\tVersione");
			System.out.println("----------------------------------------------------\n");
		
			
			@SuppressWarnings("unchecked")
			List<PacchettoDTO> pacchetti=(List<PacchettoDTO>) request.get("pacchetti");
			for (PacchettoDTO u: pacchetti)
				System.out.println(u);
			System.out.println();
		}
	}	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [B]ack [E]sci");
		String a = getInput();
		if(a.equals("l")) {
			this.choice=a;
		}
		else {
			System.out.println("operazione errata");
			showOptions();
			
		}
		
		/*if(this.choice!="l" || this.choice!="i" || this.choice!="m"|| this.choice!="c"|| this.choice!="b" || choice!="e")
        	showOptions();*/
    
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Pacchetto", "doControl", this.request);
	}

}
