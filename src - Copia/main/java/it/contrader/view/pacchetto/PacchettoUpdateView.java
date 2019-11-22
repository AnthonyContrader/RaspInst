package it.contrader.view.pacchetto;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PacchettoUpdateView extends AbstractView{
	private Request request;
	private int id;
	private String nome;
	private String categoria;
	private String data;
	private String versione;
	private final String mode = "UPDATE";
	
	public PacchettoUpdateView() {
	
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Pacchetto", null);
		}
	}
	public void showOptions() {
		try {
			System.out.println("Inserisci id del pacchetto:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome del pacchettoe:");
			nome = getInput();
			System.out.println("Inserisci categoria del pacchetto:");
			categoria = getInput();
			System.out.println("Inserisci data del pacchetto:");
			data = getInput();
			System.out.println("Inserisci versione del pacchetto:");
			versione = getInput();
		} catch (Exception e) {

		}
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("nome", nome);
		request.put("categoria", categoria);
		request.put("data", data);
		request.put("versione", versione);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Pacchetto", "doControl", request);
	}
}
