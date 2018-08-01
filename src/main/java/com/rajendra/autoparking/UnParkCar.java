
package com.rajendra.autoparking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author Rajendra_Nagaboina
 *
 */
public class UnParkCar {
	
	Scanner input = new Scanner(System.in);
	public UnParkCar() throws IOException{   
		
		System.out.print("Enter The Car Number:");
		String carNumber = input.next();
		boolean isCarValid = isValid(carNumber);
			if(isCarValid) {
				for(Map.Entry m:ParkingSpace.slot.entrySet()){  
					   if(m.getValue().equals(carNumber)) {
						   ParkingSpace.slot.remove(m.getKey());
						   ParkingSpace.list.add((Integer) m.getKey());
						   try(FileWriter fw = new FileWriter("LogFile.txt", true);
								    BufferedWriter bw = new BufferedWriter(fw);
								    PrintWriter out = new PrintWriter(bw))
							{
								    out.print("\n" + m.getKey().toString() + "," + carNumber);
								    
								   				    
								} catch (IOException e) {
								    
								} 
						   System.out.println(ParkingSpace.time.get(m.getKey()));
						   long diff = new Date().getTime() - ParkingSpace.time.get(m.getKey()) ;
						  

						   long diffSeconds = diff / 1000 % 60;
						   long diffMinutes = diff / (60 * 1000) % 60;
						   long diffHours = diff / (60 * 60 * 1000) % 24;
						   long diffDays = diff / (24 * 60 * 60 * 1000);
						   System.out.print("The Vehicle has parked for a duration of ");
						   System.out.print(diffDays + " days, ");
						   System.out.print(diffHours + " hours, ");
						   System.out.print(diffMinutes + " minutes, ");
						   System.out.print(diffSeconds + " seconds.");
						   System.out.println("\nUnparked Successfully!! Thankyou For Using Parking Service");
						   break;
					   } 
				}  
			}
			else {
				System.out.println("Enter a valid car number");
				new UnParkCar();
			}
			
	}
	/**
	 * 
	 * @param carNumber is car number
	 * @return true if it matches with regex
	 */
	public  boolean isValid(String carNumber) {
		int len = carNumber.length();
		if(len == 10) {
			String regex = "^[a-zA-z]{2}[0-9]{2}[a-zA-z]{2}[0-9]{4}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(carNumber);    
			return matcher.matches();
		}
		return false;
	}

	
}


