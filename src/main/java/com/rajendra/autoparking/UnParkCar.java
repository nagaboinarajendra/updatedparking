
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
/*
 * 
 */
public class UnParkCar {
	/*
	 * 
	 */
	long diff;
	Scanner input = new Scanner(System.in);
	/**
	 * 
	 * @throws IOException
	 */
	public UnParkCar() throws IOException{   
		
		System.out.print("Enter The Car Number:");
		String carNumber = input.next();
		boolean isCarValid = isValid(carNumber);
		if(isCarValid) {
			unparking(carNumber);
		}
		else {
			System.out.println("Enter a valid car number");
			new UnParkCar();
		}
	}
	/**
	 * 
	 * @param carNumber
	 */
	public void unparking(String carNumber) {
		for(Map.Entry m:ParkingSpace.slot.entrySet()){
			   if(m.getKey().equals(carNumber)) {
				   ParkingSpace.list.add((Integer)m.getValue());
				   saveLog((Integer)m.getValue(),carNumber);
				   InTime obj = new InTime();
				   diff = new Date().getTime() - obj.getInTime((Integer)m.getValue());
				   ParkingSpace.slot.remove(m.getKey());
				   break;
			   }
		}
		parkedDuration();
	}	
	/**
	 * 
	 */
	public void parkedDuration() {
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
	/**
	 * 
	 * @param slotNumber
	 * @param carNumber
	 */
	public void saveLog(int slotNumber, String carNumber) {
		try(FileWriter fw = new FileWriter("LogFile.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
		{
			    out.print("\n" + Integer.toString(slotNumber) + "," + carNumber);	    
		} catch (IOException e) {
			    
		}
	}
	
}


