package it.contrader.view.environment;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EnvironmentDeleteView extends AbstractView {
	private Request request;
	private int id;
	private final String mode = "DELETE";
	public EnvironmentDeleteView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Environment", null);
		}
	}
	@Override
	public void showOptions() {
			System.out.println("Inserisci id dell'Environment:");
			id = Integer.parseInt(getInput());
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Envirnment", "doControl", request);
	}
}
