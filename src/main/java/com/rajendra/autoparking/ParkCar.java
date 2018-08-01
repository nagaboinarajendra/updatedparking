package com.rajendra.autoparking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator;
import java.util.Map;
/**
 * 
 * @author Rajendra_Nagaboina
 *
 */
public class ParkCar {
	
	private String carNumber;
	Scanner input = new Scanner(System.in);
	public ParkCar() throws IOException {
		
		if(ParkingSpace.getReminingSlots() != 0) {
			System.out.print("Enter The Car Number:");
			carNumber = input.next();
			park(carNumber);
		}
		else {
			System.out.println("Parking space is full");
		}
	}	
			
	public void park(String carNumber) throws IOException {
		
		if(isValid(carNumber)) {
			if(isPresent(carNumber)) {
				 for(Map.Entry m:ParkingSpace.slot.entrySet()){
					   if(m.getValue().equals(carNumber)) {
						   System.out.println("Vehicle already parked in Parking Area at slot number" + m.getKey());
					   }
				 }
			 }
			else {
				Iterator<Integer> itr2=ParkingSpace.list.iterator();		 
				if(itr2.hasNext()) {
					int slotNumber = itr2.next();
					ParkingSpace.slot.put(slotNumber, carNumber);
					System.out.println("parked successfully at slot" + slotNumber);
					inTime(slotNumber);
					ParkingSpace.list.remove(slotNumber);

				}
				else {
					
				ParkingSpace.slot.put(ParkingSpace.getSlotNumber(), carNumber);
				System.out.println("parked successfully at slot" + ParkingSpace.getSlotNumber());
				inTime(ParkingSpace.getSlotNumber());
				
				try(FileWriter fw = new FileWriter("Transaction.txt", true);
					    BufferedWriter bw = new BufferedWriter(fw);
					    PrintWriter out = new PrintWriter(bw))
				{
					    out.print("\n" + Integer.toString(ParkingSpace.getSlotNumber()) + "," + carNumber);
					    
					   				    
					} catch (IOException e) {
					    
					}   
				ParkingSpace.setSlotNumber(ParkingSpace.getSlotNumber()+1);
				}
			 }
		}
		else {
			System.out.println("Enter a valid car number");
			new ParkCar();
		}
	}
		
	/**
	 * 
	 * @param carNumber2 is car number
	 * @return true if car number is present
	 */
	private boolean isPresent(String carNumber2) {
		for(Map.Entry m:ParkingSpace.slot.entrySet()){  
			   if(m.getValue().equals(carNumber2)) {
				   return true;
			   }  
		} 
		return false;
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
	 * @param slot number of the car
	 */
	public  void inTime(int slot) {   
        ParkingSpace.time.put(slot,new Date().getTime());
        
	}
	
	
}

