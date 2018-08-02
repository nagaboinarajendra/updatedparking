package com.rajendra.autoparking;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class CsvReader {
    /*
     * 
     */
	public CsvReader() {
    	File file = new File("Transaction.txt");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
        	InTime intime = new InTime();
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                ParkingSpace.slot.put(country[1], Integer.parseInt(country[0]));
                intime.setInTimesOfTransactionCars(Integer.parseInt(country[0]), Long.parseLong(country[2]));
                ParkingSpace.updateSlotsRemaining();
	            ParkingSpace.updateSlotNumber();
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

