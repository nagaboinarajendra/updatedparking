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
	/*
	 * 
	 */
	private String carNumber;
	/*
	 * 
	 */
	
	Scanner input = new Scanner(System.in);
	/**
	 * 
	 * @throws IOException
	 */
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
	
	Iterator<Integer> itr2=ParkingSpace.list.iterator();
	/**
	 * 
	 * @param carNumber
	 * @throws IOException
	 */
	public void park(String carNumber) throws IOException {
		
		if(isValid(carNumber)) {
			if(isPresent(carNumber)) {
				System.out.println("Vehicle already parked in Parking Area at slot number" + ParkingSpace.slot.get(carNumber));
			 }
			else {
				parking();
			}
		}
		else {
			System.out.println("Enter a valid car number");
			new ParkCar();
		}
	}
	/**
	 * 
	 */
	public void parking() {
		if(itr2.hasNext()) {
			int slotNumber = itr2.next();
			ParkingSpace.slot.put(carNumber, slotNumber);
			System.out.println("parked successfully at slot" + slotNumber);
			inTime(slotNumber);
			ParkingSpace.list.remove(slotNumber);
			saveRecord(slotNumber,carNumber);

		}
		else {
			
		ParkingSpace.slot.put(carNumber, ParkingSpace.getSlotNumber());
		System.out.println("parked successfully at slot" + ParkingSpace.getSlotNumber());
		inTime(ParkingSpace.getSlotNumber());
		saveRecord(ParkingSpace.getSlotNumber(),carNumber);
		ParkingSpace.setSlotNumber(ParkingSpace.getSlotNumber()+1);
		}
	}
	/**
	 * 
	 * @param slotNumber
	 * @param carNumber
	 */
	public void saveRecord(int slotNumber, String carNumber) {
		try(FileWriter fw = new FileWriter("Transaction.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
		{		InTime obj = new InTime();
			    out.print("\n" + Integer.toString(slotNumber) + "," + carNumber + "," +obj.getInTime(slotNumber));	    
		} catch (IOException e) {
			    
		}
	}
	/**
	 * 
	 * @param carNumber2 is car number
	 * @return true if car number is present
	 */
	private boolean isPresent(String carNumber2) {
		for(Map.Entry m:ParkingSpace.slot.entrySet()){  
			   if(m.getKey().equals(carNumber2)) {
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
	public void inTime(int slot) {   
		InTime obj = new InTime();
		obj.setInTime(slot);
	}
	
}

