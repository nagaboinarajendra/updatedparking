package com.rajendra.autoparking;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CarNumberValidate 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CarNumberValidate( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CarNumberValidate.class );
    }

    public void testValidate() {
    	assertTrue(ParkCar.validate("ap29cb1118"));
    	assertFalse(ParkCar.validate("adsfadf"));
    	assertFalse(ParkCar.validate("234234"));
    }
}

