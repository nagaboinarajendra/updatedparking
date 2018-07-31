package com.rajendra.autoparking;

import java.util.Scanner;
/**
 * 
 * @author Rajendra_Nagaboina
 *
 */
public class Admin {
	final String username = "admin";
	final String password = "admin";
	boolean isAdminValid = false;
	boolean adminLogin = false;
	Scanner adminCredentials = new Scanner(System.in);
	public Admin(){
		System.out.print("USERNAME:");
		String adminUsername = adminCredentials.next();
		System.out.print("\nPASSWORD:");
		String adminPassword = adminCredentials.next();
		validateAdmin(adminUsername,adminPassword);
	}

	/**
	 * 
	 * @param username of admin
	 * @param password of admin
	 * @return
	 */
	public void  validateAdmin(String username, String password) {
		if( this.username.equals(username) && this.password.equals(password)) {
			this.isAdminValid =true;
			this.adminLogin = true;
		}
		else {
			this.isAdminValid = false;
		}
	}
	
}
