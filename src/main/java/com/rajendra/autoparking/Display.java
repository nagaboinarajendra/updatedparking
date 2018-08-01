package com.rajendra.autoparking;

import java.util.Map;

public class Display {
	
	public  Display() {
		if(ParkingSpace.getReminingSlots() > 0) {
		for(Map.Entry m:ParkingSpace.slot.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());  
			  }  
		}
		else {
			System.out.println("parking space empty");
		}
	}
}
