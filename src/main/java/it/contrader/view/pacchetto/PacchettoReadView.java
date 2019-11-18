package it.contrader.view.pacchetto;
import it.contrader.view.AbstractView;
import it.contrader.controller.Request;
import it.contrader.dto.PacchettoDTO;
import it.contrader.main.MainDispatcher;
public class PacchettoReadView extends AbstractView{
	private int id;
	private Request request;
	private final String mode = "READ";

	public PacchettoReadView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request != null) {
			PacchettoDTO pacchetto = (PacchettoDTO) request.get("pacchetto");
			System.out.println(pacchetto);
			MainDispatcher.getInstance().callView("Pacchetto", null);
		}
	}
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del pacchetto:");
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
