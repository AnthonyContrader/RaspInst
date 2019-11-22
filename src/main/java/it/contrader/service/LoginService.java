package it.contrader.service;

import it.contrader.dao.LoginDAO;
import it.contrader.main.SharedData;

public class LoginService {

	private LoginDAO loginDAO;
	/**
	 * Costruttore della classe, crea un oggetto di tipo LoginDAO per poter chiamare il metodo del DAO
	 */
	public LoginService() {
		this.loginDAO = new LoginDAO();
	}

	/**
	 * Chiama il metodo del DAO e ottiene una stringa (lo usertype)
	 */
	public String login (String username, String password) {
		String usertype = this.loginDAO.login(username, password);
		SharedData.loggedUsertype = usertype;
		return usertype;
	}
}
