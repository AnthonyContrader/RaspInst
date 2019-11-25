package it.contrader.controller;

import java.util.List;

import it.contrader.dto.EnvironmentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.SharedData;
import it.contrader.service.EnvironmentService;

public class EnvironmentController implements Controller{
	
	private static String sub_package = "environment.";
	private EnvironmentService environmentService;
	public EnvironmentController() {
		this.environmentService=new EnvironmentService();
	}
	@Override
	public void doControl(Request request){
		String mode=(String) request.get("mode");
		String choice=(String) request.get("choice");
		int id;
		String nome;
		switch (mode) {
		case "showView":
			if(SharedData.isAdmin())
				MainDispatcher.getInstance().callView("Environment", null);	
			if(SharedData.isUser())
				MainDispatcher.getInstance().callView("EnvironmentUser", null);	
			break;
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			EnvironmentDTO environmentDTO = environmentService.read(id);
			request.put("environment", environmentDTO);
			MainDispatcher.getInstance().callView(sub_package + "EnvironmentRead", request);
			break;
		case "INSERT":
			nome = request.get("nome").toString();
			//costruisce l'oggetto Environment da inserire
			EnvironmentDTO environmentToInsert = new EnvironmentDTO(nome);
			//invoca il service
			environmentService.insert(environmentToInsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "EnvironmentInsert", request);
			break;	
			// Arriva qui dalla EnvironmentDeleteView. Estrae l'id dell'environment da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			environmentService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EnvironmentDelete", request);
			break;
			// Arriva qui dalla environmentUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			nome = request.get("nome").toString();
			EnvironmentDTO environmentToUpdate = new EnvironmentDTO(nome);
			environmentToUpdate.setId(id);
			environmentService.update(environmentToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "EnvironmentUpdate", request);
			break;
			//Arriva qui dalla EnvironmentView Invoca il Service e invia alla EnvironmentView il risultato da mostrare 
		case "ENVIRONMENTLIST":
			List<EnvironmentDTO> environmentsDTO = environmentService.getAll();
			//Impacchetta la request con la lista degli environment
/*occhio*/  request.put("environments", environmentsDTO);
			if(SharedData.isAdmin()) {
				MainDispatcher.getInstance().callView("Environment", request);
			}
			else if(SharedData.isUser()) {
					MainDispatcher.getInstance().callView("EnvironmentUser", request);
			}
		//	MainDispatcher.getInstance().callView("Environment", request);
			break;
			//Esegue uno switch sulla base del comando inserito dall'environment e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
			//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
			//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
				case "L":
					MainDispatcher.getInstance().callView(sub_package + "EnvironmentRead", null);
					break;
					
				case "I":
					MainDispatcher.getInstance().callView(sub_package + "EnvironmentInsert", null);
					break;
					
				case "M":
					MainDispatcher.getInstance().callView(sub_package + "EnvironmentUpdate", null);
					break;
					
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "EnvironmentDelete", null);
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
