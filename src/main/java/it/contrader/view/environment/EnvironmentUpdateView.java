package it.contrader.view.environment;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EnvironmentUpdateView extends AbstractView{
	private Request request;
	private int id;
	private String nome;
	private final String mode = "UPDATE";
	public EnvironmentUpdateView() {
		
	}
	@Override
	public void showResults(Request request) {
		if(request!=null) {
			System.out.println("Modifica andata a buon fine.\\n");
			MainDispatcher.getInstance().callView("Environment",null);
			
		}
	}
	@Override
	public void showOptions() {
		try {
			System.out.println("inserisci l'id dell'Environment");
			id=Integer.parseInt(getInput());
			System.out.println("inserisci il nome dell'Environment");
			nome=getInput();
		}
		catch(Exception e) {
			
		}
	}
	@Override
	public void submit() {
		request=new Request();
		request.put("id", "id");
		request.put("nome", nome);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Environment", "doControl", request);
	}
	
}
