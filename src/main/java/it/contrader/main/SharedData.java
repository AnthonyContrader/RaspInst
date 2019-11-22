package it.contrader.main;

import it.contrader.dto.UserDTO;

public class SharedData {
	public static String loggedUsertype;
	public static boolean isUser() {
		return loggedUsertype.equalsIgnoreCase("user");
	}
	public static boolean isAdmin() {
		return loggedUsertype.equalsIgnoreCase("admin");
	}
}
