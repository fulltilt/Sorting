package algorithms.sort;

public class HeapSort {
	public static void heapSort(int[] array) 
	{
		/** code to create a new array that is pretty much the same but whose size is increased by 1 to accommodate 0 element */ 
		int[] tempArray = new int[array.length + 1];
		for (int i = 0; i < array.length; i++)
			tempArray[i + 1] = array[i];
		/***/
				
		int N = tempArray.length - 1;

		// take array elements and construct a heap
	    for (int k = N / 2; k >= 1; k--)
	    	sink(tempArray, k, N);	
		
		// sort heap by swapping the root with each index
	    while (N > 1)
	    {
	        swap(tempArray, 1, N--);
	        sink(tempArray, 1, N);
	    }
	    
	    // copy sorted array back into original array (tempArray has that extra '0' element)
	    for (int i = 0; i < array.length; i++)
	    	array[i] = tempArray[i + 1];
	}

    public static void sink(int[] array, int k, int N) 
    {
        while (2 * k <= N) {	                    
        	int j = 2 * k;							
            if (j < N && (array[j] < array[j + 1])) j++;
            if (array[k] > array[j]) break;				
            swap(array, k, j);							
            k = j;									
       } 
    }	

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}

class MaxPQ 
{
	private int[] pq;             // heap-ordered complete binary tree
    private int N = 0;            //    in pq[1..N] with pq[0] unused (reason being for the math. If the first element starts
                                  // at index 1, the math is a lot easier
   
    public MaxPQ (int maxN) {  pq = new int[maxN + 1];  } // you need the extra '1' to accommodate the empty '0' element 
   
    public boolean isEmpty() {  return N == 0;  }
    public int size()        {  return N;  }
   
    public void print() {
    	for (int a : pq)
    		System.out.println(a);
    }
    
    public void insert(int v) {  
    	pq[++N] = v;
        swim(N);
    }
    
    public int delMax() {  
        int max = pq[1];           // Retrieve max key from top (the 1st index is always the largest key)
        swap(pq, 1, N--);          // Exchange with last item (swap the last element in the heap with the empty root)
        //pq[N + 1] = null;          // Avoid loitering.
        sink(1);                   // Restore heap property.
        return max;
    }

    /*
     * if node is bigger than the parent, 'swim-up' the hierarchy and swap to maintain heap order. Called after a new element
     * is added to the heap
     * k: represents a node index
     * -note: keep in mind that the parent of the node at position k in a heap is at position k / 2
     */
    private void swim(int k) 
    {
    	while (k > 1 && (pq[k / 2] < pq[k]))	// the conditional after && says 'if element at parent is < element of current index'
        {
    		swap(pq, k / 2, k);	// if parent element is less than current element, swap
            k = k / 2;  		// propagate up the heap to the root if necessary (the root is when k == 1)
        } 
    }
    
    /*
     * if node is smaller than the the child, 'swim-down' the hierarchy and swap with the LARGER of the node's children.
     * Called after the max element is removed and the last element is swapped to the root position
     * k: represents a node index
     * -note: the nodes children are at 2k and 2k + 1 
     */
    private void sink(int k) 
    {
        while (2 * k <= N) {	                    // while the current index' child is less than the size of the array
        	int j = 2 * k;							// assign j to be the left-child
            if (j < N && (pq[j] < pq[j + 1])) j++;	// if the left-child is smaller than the right-child, set j to be the right-child
            if (pq[k] > pq[j]) break;				// if k's element is greater than k's largest childs' element, break
            swap(pq, k, j);							// if we got this far, this implies that k's largest childs element is larger than k's element
            k = j;									// set k to be the index of j (j used to be the index of k's biggest child before the swap)
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