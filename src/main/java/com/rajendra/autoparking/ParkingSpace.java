package com.rajendra.autoparking;

import java.util.Hashtable;
import java.util.PriorityQueue;

/**
 * 
 * @author Rajendra_Nagaboina
 *
 */
public class ParkingSpace {
	
	private static int totalSlots;
	private static int slotsRemaining = 0;
	private static int slotNumber =1;
	
	 static Hashtable<Integer,String> slot=new Hashtable<Integer,String>();
	 static PriorityQueue<Integer> list=new PriorityQueue<Integer>();
	 static Hashtable<Integer,Long> time=new Hashtable<Integer,Long>();
	/**
	 * 
	 * @param slot parking slot of vehicle
	 */
	public ParkingSpace(int slot){
		ParkingSpace.totalSlots = slot;
		slotsRemaining = totalSlots;
	}
	
	
	public static void updateSlotsRemaining() {
		slotsRemaining-=1;
	}
	/**
	 * 
	 * @return number of slots remaining
	 */
	public static int getReminingSlots() {
		return slotsRemaining;
	}
	/**
	 * 
	 * @return slot number of Vehicle
	 */
	public static  int getSlotNumber() {
		return slotNumber;
	}
	public static void updateSlotNumber() {
		slotNumber+=1;
	}
	/**
	 * 
	 * @param slotNumber of the vehicle
	 */
	public static void setSlotNumber(int slotNumber) {
		ParkingSpace.slotNumber = slotNumber;
	}

	
   }

