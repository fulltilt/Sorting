package algorithms.sort;

public class SelectionSort {
	public static void selectionSort(int[] array) {
		// iterate through array one element at a time. At each iteration, swap the smallest element with the current index
		for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
			int smallestElementIndex = currentIndex;
			
			// iterate through rest of array to find the smallest element
			for (int j = currentIndex; j < array.length; j++) {
				if (array[j] < array[smallestElementIndex])
					smallestElementIndex = j;
			}
			
			swap(array, currentIndex, smallestElementIndex);
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
