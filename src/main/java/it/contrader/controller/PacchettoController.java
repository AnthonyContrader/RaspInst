package it.contrader.controller;

import java.util.List;
import it.contrader.dto.PacchettoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.SharedData;
import it.contrader.service.PacchettoService;
//import it.contrader.view.PacchettoUserView;

public class PacchettoController implements Controller{
	
	private static String sub_package = "pacchetto.";
	private PacchettoService pacchettoService;
	public PacchettoController() {
		this.pacchettoService=new PacchettoService();
	}
	@Override
	public void doControl(Request request){
		String mode=(String) request.get("mode");
		String choice=(String) request.get("choice");
		int id;
		String nome;
		String categoria;
		String data;
		String versione;
		
		switch (mode) {
		case "showView":
			if(SharedData.isAdmin())
				MainDispatcher.getInstance().callView("Pacchetto", null);	
			if(SharedData.isUser())
				MainDispatcher.getInstance().callView("PacchettoUser", null);	
			break;
		case "READ":	
			id = Integer.parseInt(request.get("id").toString());
			PacchettoDTO pacchettoDTO = pacchettoService.read(id);
			request.put("pacchetto", pacchettoDTO);
				MainDispatcher.getInstance().callView(sub_package + "PacchettoRead", request);
		//	mode="showView";
			break;
		case "INSERT":			
			nome = request.get("nome").toString();
			categoria = request.get("categoria").toString();
			data = request.get("data").toString();
			versione = request.get("versione").toString();
			//costruisce l'oggetto pacchetto da inserire
			PacchettoDTO pacchettoToInsert = new PacchettoDTO(nome, categoria, data, versione);
			//invoca il service
			pacchettoService.insert(pacchettoToInsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "PacchettoInsert", request);
			break;
			// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			pacchettoService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PacchettoDelete", request);
			break;
			// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			nome = request.get("nome").toString();
			categoria = request.get("categoria").toString();
			data = request.get("data").toString();
			versione = request.get("versione").toString();
			PacchettoDTO pacchettoToUpdate = new PacchettoDTO(nome, categoria, data, versione);
			pacchettoToUpdate.setId(id);
			pacchettoService.update(pacchettoToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PacchettoUpdate", request);
			break;
			//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "PACCHETTOLIST":
			List<PacchettoDTO> pacchettiDTO = pacchettoService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("pacchetti", pacchettiDTO);
			if(SharedData.isAdmin()) {
				MainDispatcher.getInstance().callView("Pacchetto", request);
			} else if(SharedData.isUser()) {
				MainDispatcher.getInstance().callView("PacchettoUser", request);
			}
			break;
			//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
			//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
			//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
				case "L":			
					MainDispatcher.getInstance().callView(sub_package + "PacchettoRead", null);
					break;
					
				case "I":
					System.out.println("Sono in pacchetto controller");
					MainDispatcher.getInstance().callView(sub_package + "PacchettoInsert", null);
					break;
					
				case "M":
					MainDispatcher.getInstance().callView(sub_package + "PacchettoUpdate", null);
					break;
					
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "PacchettoDelete", null);
					break;
					
				case "E":
					MainDispatcher.getInstance().callView("Login", null);
					break;

				case "B":
					MainDispatcher.getInstance().callView("HomeAdmin", null);
					break;
					
				default:
					MainDispatcher.getInstance().callView("Login", null);
				}
				
			default:
				MainDispatcher.getInstance().callView("Login", null);

		}
	}
}
