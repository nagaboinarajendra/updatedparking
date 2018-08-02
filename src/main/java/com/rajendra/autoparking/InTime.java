package com.rajendra.autoparking;

import java.util.Date;

/**
 * 
 * @author rajendra
 *
 */
public class InTime {
	/*
	 * 
	 */
	private long inTime;
	
	static long[] intime = new long[50];
	/**
	 * @return the inTime
	 */
	public long getInTime(int slot) {
		System.out.println(intime[slot]);
		return intime[slot];
	}

	/**
	 * @param inTime the inTime to set
	 */
	public void setInTime(int slot) {
		intime[slot] = new Date().getTime();
	}
	
}
