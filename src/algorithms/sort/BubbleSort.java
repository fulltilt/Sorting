package algorithms.sort;

public class BubbleSort {
	public static void bubbleSort(int[] array) {
		boolean swapped = true;	// array will be sorted once we go through the entire array without one swap
		int j = 0; 				// spacing from end of array. After the first iteration, the biggest item will be at
		                        // the end so no need to compare that field. After the 2nd iteration, the 2 biggest
		                        // items will be at the end of the array so no need to compare those fields....
		while (swapped) {
			swapped = false;
			j++;

			// iterate through array and compare 1st and 2nd, then 2nd and 3rd, etc. making swaps along the way as necessary
			for (int i = 0; i < array.length - j; i++) {
 				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					swapped = true;
				}
			}
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
