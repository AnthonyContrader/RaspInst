package it.contrader.view;
import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.main.MainDispatcher;
public class EnvironmentView extends AbstractView {
	private Request request;
	private String choice;

	public EnvironmentView() {
	}
	@Override
	public void showResults(Request request) {
	if (request != null) {
			System.out.println("\n------------------- Gestione environment ----------------\n");
			System.out.println("ID\tNome");
			System.out.println("----------------------------------------------------\n");
			@SuppressWarnings("unchecked")
			List<EnvironmentDTO> environments = (List<EnvironmentDTO>) request.get("environments");
			for (EnvironmentDTO u: environments)
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
		MainDispatcher.getInstance().callAction("Environment", "doControl", this.request);
	}	
}
