package com.rajendra.autoparking;

import java.util.Scanner;

/**
 * 
 * @author Rajendra_Nagaboina
 *
 */
public class Main {
/**
 * 
 * @param args
 */
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Admin admin = new Admin();
		if(admin.isAdminValid) {
			while(admin.adminLogin) {
				System.out.println("Select one of the following:\n1.park the car\n2.Unpark the car\n3.exit\n4.display");
				int choice = input.nextInt();
				switch(choice) {
				case 1:	new ParkCar();
						break;
				case 2: new UnParkCar();
						break;
				case 3: admin.adminLogin = false;
						System.out.println("Thankyou for visiting!!!");
						break;
				case 4: new Display();
				}
				}
			}
			else {
			System.out.println("The entered credentials are incorrect!!\n Please enter the correct credentials!");
			new Admin();
			}
		input.close();
	}				
}

