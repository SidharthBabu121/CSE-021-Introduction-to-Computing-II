package oop;


/**
 * A counter class that cycles its internal value back to 0 when it
 * reaches a maximum value. 
 * 
 * e.g., A (new) ModNCounter with a cycleLength (maximum) of 5 will
 * have an internal value of 2 after increment() is called 7 times
 */
public class ModNCounter  extends Counter { 


    private int cycleLength; 

    public ModNCounter (int n) { 
    	cycleLength = n; 
    }  
    
    public int value () {
    	return super.value();
    }
    
    public void increment() { 
    	// fill in this method so that value() will return
    	// the correct value
    	if(value() == cycleLength - 1)
    		reset();
    	else
    		super.increment();
    	
    } 
} 