package oop;
 
public class DecrementableCounter extends Counter{
	public DecrementableCounter() {
		
	}

	public void decrement() {
	  int current_count = value();
	  reset();
	  for (int i = 0; i <= current_count - 2; i++) {
		  increment();
	  }
	}
	

}
