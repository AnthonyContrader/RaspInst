package it.contrader.view.pacchetto;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PacchettoInsertView extends AbstractView{
	private Request request;
	private String nome;
	private String categoria;
	private String data;
	private String versione;
	private final String mode="INSERT";
	
	public PacchettoInsertView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Pacchetto", null);
		}
	}
	@Override
	public void showOptions() {
			System.out.println("Inserisci nome del pacchetto:");
			nome = getInput();
			System.out.println("Inserisci categoria del pacchetto:");
			categoria = getInput();
			System.out.println("Inserisci data del pacchetto:");
			data = getInput();
			System.out.println("Inserisci versione del pacchetto:");
			versione = getInput();
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("nome", nome);
		request.put("categoria", categoria);
		request.put("data", data);
		request.put("versione", versione);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Pacchetto", "doControl", request);
	}			
}
