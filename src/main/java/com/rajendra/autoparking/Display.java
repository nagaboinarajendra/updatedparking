package com.rajendra.autoparking;

import java.util.Map;

public class Display {
	
	public  Display() {
		 for(Map.Entry m:ParkingSpace.slot.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());  
			  }  
		
	}
}
