package it.contrader.view.environment;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
public class EnvironmentInsertView extends AbstractView{
	private Request request;
	private String nome;
	private final String mode = "INSERT";
	public EnvironmentInsertView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Environment", null);
		}
	}
	@Override
	public void showOptions() {
			System.out.println("Inserisci nome del pacchetto:");
			nome = getInput();
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("nome", nome);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Environment", "doControl", request);
	}
}
