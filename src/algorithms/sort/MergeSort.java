package algorithms.sort;

public class MergeSort {
	private static int[] aux;      // auxiliary array for merges
	
	public static void mergeSort(int[] array) {
		aux = new int[array.length];
		mergeSort(array, 0, array.length - 1);
	}
	
	public static void mergeSort(int[] array, int lo, int hi) {
		// base case
	    if (hi <= lo) 
	    	return;
	    
	    // Sort a[lo...hi].
	    int mid = lo + (hi - lo) / 2;
	    mergeSort(array, lo, mid);         // Sort left half.
	    mergeSort(array, mid + 1, hi);     // Sort right half.
	    merge(array, lo, mid, hi);         // Merge results.
	}

	/*
	 * merge two disjoint ordered arrays into a third one
	 * strategy: create an output array of the  requisite  size  and  then  choose  successively  the  smallest  
	 * remaining  item  from  the  two input arrays to be the next item added to the output array
	 * -make a duplicate copy of the array. Use that duplicate copy to reorder the original array in the original array
	 * -note: lo, mid and hi are referring to array indices
	 * -mid is calculated as (lo + (hi - lo)) / 2
	 */
	public static void merge(int[] a, int lo, int mid, int hi) 
	{  // Merge a[lo...mid] with a[mid + 1...hi].
	   int i = lo, j = mid + 1;

	   for (int k = lo; k <= hi; k++)  // Copy a[lo...hi] to aux[lo...hi].
	      aux[k] = a[k];
	   
	   for (int k = lo; k <= hi; k++)  // Merge back to a[lo...hi].
	      if      (i > mid)              a[k] = aux[j++];  // left half exhausted (take from the right)
	      else if (j > hi )              a[k] = aux[i++];  // right half exhausted (take from the left)
	      else if (aux[j] < aux[i])      a[k] = aux[j++];  // current key on right less than current key on left (take from the right)
	      else                           a[k] = aux[i++];  // current key on right greater than or equal to current key on left (take from the left)
	}
}
