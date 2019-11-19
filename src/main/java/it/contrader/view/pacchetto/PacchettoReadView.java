package it.contrader.view.pacchetto;
import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.PacchettoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
public class PacchettoReadView extends AbstractView{
	private int id;
	private Request request;
	private final String mode = "READ";

	public PacchettoReadView() {
		
	}
	@Override
	public void showResults(Request request) {
		System.out.println("Sono entrato dentro show result in PacchettoReadView");
		if( request != null) {
			if(request.get("pacchetto") instanceof List) {
			}else {
				System.out.println("Sto per stampare i dati");
				PacchettoDTO pacchetto = (PacchettoDTO) request.get("pacchetto");
				System.out.println(pacchetto);
				System.out.println("Ho stampato i datis");
				MainDispatcher.getInstance().callView("Pacchetto", null);
			}
		}
		/*if (request != null) {
			System.out.println("Sto per stampare i dati");
			PacchettoDTO pacchetto = (PacchettoDTO) request.get("pacchetto");
			System.out.println(pacchetto);
			System.out.println("Ho stampato i datis");
			MainDispatcher.getInstance().callView("Pacchetto", null);
		}*/
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
