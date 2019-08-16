
package bullet;


public class FindDuplicateCount {

	public static void main(String[] args) {
		
		
		int count = 0;
		
		int[] arr = {1, 2, 2, 3, 4, 2, 4, 3, 0, 5, 3, 2};
		int [] arr1 = new int[arr.length];
		
		arr1 = arr.clone();
		
		for (int i = 0; i < arr.length; i++) {
			count = 0;
			for (int j = i + 1; j < arr1.length; j++) {
				if(arr[i] == arr1[j]) 
				  count++;
				
			}
			
			if(count == 0) {
				System.out.println("There are no duplicates with value " + arr1[i] + " beyond index " + i);
			}
			if (count > 1) 
				System.out.println("There are " + count + " more occurances of value " + arr1[i] + " starting at index " + i);
			
			if (count == 1) 
				System.out.println("There are only " + count +"more occurances of value " + arr1[i] + " starting at index " + i);
		}
		
		
		
		
		
		
	}

  }

