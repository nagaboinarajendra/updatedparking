package com.rajendra.autoparking;
import java.util.Map;
/**
 * 
 * @author rajendra
 *
 */
public class Display {
	/**
	 * displays the list of cars with slot number
	 */
	public  Display() {
		if(ParkingSpace.getReminingSlots() > 0) {
		for(Map.Entry m:ParkingSpace.slot.entrySet()){  
			   System.out.println(m.getValue()+" "+m.getKey());  
			  }  
		}
		else {
			System.out.println("parking space empty");
		}
	}
}
