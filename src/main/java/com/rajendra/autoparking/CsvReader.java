package com.rajendra.autoparking;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class CsvReader {
	


	    public CsvReader() {
	    	
	    	File file = new File("Transaction.txt");
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(file));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] country = line.split(cvsSplitBy);
	                ParkingSpace.slot.put(Integer.parseInt(country[0]), country[1]);
	                ParkingSpace.updateSlotsRemaining();;
		            ParkingSpace.updateSlotNumber();;

	            }
	            

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	    }

	}

