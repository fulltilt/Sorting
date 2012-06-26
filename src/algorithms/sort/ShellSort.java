package algorithms.sort;

public class ShellSort {
	public static void shellSort(int[] array) {
		int N = array.length;
		
		// determine the initial h value
		int h = 1;
	    while (h < N / 3) 
	    	h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
	    
	    while (h >= 1) {
	    	// h-sort the array
	    	for (int i = h; i < array.length; i++) {
	    		// do insertion sort for h-sized array
	    		for (int j = i; j >= h && array[j] < array[j - h]; j -= h)
	    			swap(array, j, j - h);
	    	}
	    	
	    	h = h / 3; // reverse the h-size
	    }
	}
	
	/*
	 * swaps data elements between 2 indexes of an array
	 */
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}	
}
