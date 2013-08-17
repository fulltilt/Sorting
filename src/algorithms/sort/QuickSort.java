package algorithms.sort;

public class QuickSort {
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	public static void quickSort(int[] array, int lo, int hi) {
		// base case
		if (hi <= lo) 
			return;
	    
		int j = partition(array, lo, hi);  		  // Partition 
	    quickSort(array, lo, j - 1);              // Sort left part a[lo ... j-1].
	    quickSort(array, j + 1, hi);              // Sort right part a[j+1 ... hi].
	}
	
	/*
	 * partition array where the partition is the 1st index value. At the end of the fxn, the partition item will be 
	 * in it's proper place and elements lower than the partitioning index are placed before the partition and all elements
	 * bigger than the partitioning index are placed after the partition
	 * -note: lo and hi are array indices
	 */
	private static int partition(int[] array, int lo, int hi) {  // Partition into a[lo...i - 1], a[i], a[i + 1...hi]. 
	   int i = lo, j = hi + 1;           		 // left and right scan indices
	   int v = array[lo];   		             // partitioning item
	   
	    while (true) {  
		    // scan from left to right until you hit an index whose element is 
			// bigger than the partitioning item or if 'i' is equal to 'hi' 
			// (implies that all remaining elements in array are bigger than the 
			// partitioning item)
	        while (array[++i] < v) 
	            if (i == hi) 	// condition to avoid out of bounds exceptions if the list is already sorted
	           	    break;

			// scan from right to left until you hit an index whose element is 
	       	// bigger than the partitioning item or if 'j' is equal t 'lo' 
           	// (implies that all remaining elements in array are smaller than the 
	       	// partitioning item)
	        while (v < array[--j]) 
	       	   if (j == lo)		// condition to avoid out of bounds exceptions if the list is already sorted 
	       	   	   break;

	        if (i >= j) 	// when left scan index is equal to or greater than right scan index, break out of while loop
	            break;
	       
	        swap(array, i, j);	// if we got this far, 'i' is an index to an element that is greater than the partitioning item
	                            // and 'j' is an index to an element that is less than the partitioning item. In this case,
	                            // swap the items so they are on the correct side of the partition. Continue to scan afterwards
	   }
	   
	   swap(array, lo, j);       // Put v = a[j] into position (iow, swap the partioning item with j which would be the its
	   							 // proper position when the array is sorted
	   return j;                 // with a[lo..j-1] <= a[j] <= a[j+1..hi] (iow, return the partitioning items new index)
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
