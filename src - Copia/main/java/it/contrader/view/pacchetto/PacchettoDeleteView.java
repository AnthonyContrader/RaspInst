package it.contrader.view.pacchetto;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PacchettoDeleteView extends AbstractView{
	private Request request;
	private int id;
	private final String mode="DELETE";
	public PacchettoDeleteView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Pacchetto", null);
		}
	}
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del pacchetto:");
			id = Integer.parseInt(getInput());
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Pacchetto", "doControl", request);
	}
}
