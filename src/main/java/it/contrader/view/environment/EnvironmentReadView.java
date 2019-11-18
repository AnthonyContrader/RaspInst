package it.contrader.view.environment;
import it.contrader.controller.Request;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
public class EnvironmentReadView extends AbstractView{
	private int id;
	private String nome;
	private Request request;
	private final String mode="READ";
	public EnvironmentReadView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request != null) {
			EnvironmentDTO environment= (EnvironmentDTO) request.get("environment");
			System.out.println(environment);
			MainDispatcher.getInstance().callView("Environment", null);
		}
	}
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'utente:");
		id = Integer.parseInt(getInput());
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Environment", "doControl", request);
	}	
}
