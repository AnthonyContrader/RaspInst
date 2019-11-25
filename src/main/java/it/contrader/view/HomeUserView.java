package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;

	@Override
	public void showResults(Request request) {
		System.out.println("\n Benvenuto in RASPINST-CONSOLE "+request.get("username").toString() + "\n");

	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("e[N]vironment [P]acchetti  [B]ack   [E]xit ");
	//	System.out.println("\n Esatto, puoi solo uscire...");
		choice = this.getInput();

	}

	@Override
	public void submit() {
		Request request = new Request();
		switch (choice) {

		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;
		case "p":
			request.put("mode", "PACCHETTOLIST");
        	MainDispatcher.getInstance().callAction("Pacchetto", "doControl", request);
        	break;
		case "n":
			request.put("mode", "ENVIRONMENTLIST");
        	MainDispatcher.getInstance().callAction("Environment", "doControl", request);
        	break;
		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
