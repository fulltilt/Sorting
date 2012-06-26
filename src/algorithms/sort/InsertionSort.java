package algorithms.sort;

public class InsertionSort {
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			// assuming as long as array[i] is less, Insert array[i] among array[i-1], array[i-2], array[i-3]... 
			for (int j = i; j > 0 && array[j - 1] > array[j]; j--)	// work backwards from the outer loop index
				swap(array, j - 1, j);
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
