package algorithms.sort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortingAlgorithmsTest {
    private int[] array = { 77, 99, 44, 55, 22, 88, 11, 0, 66, 33 };
    private int[] sortedArray = { 0, 11, 22, 33, 44, 55, 66, 77, 88, 99 };

    @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {
        array = null;
        sortedArray = null;
    }

    @Test
    public void testBubbleSort() {
        BubbleSort.bubbleSort(array);
        
        assertEquals(array.length, sortedArray.length);		// test that the array lengths are the same

        for (int i = 0; i < array.length; i++)
        	assertEquals(array[i], sortedArray[i]);
    }
    
    @Test
    public void testSelectionSort() {
    	SelectionSort.selectionSort(array);
        
        assertEquals(array.length, sortedArray.length);		// test that the array lengths are the same

        for (int i = 0; i < array.length; i++)
        	assertEquals(array[i], sortedArray[i]);
    }   
    
    @Test
    public void testInsertionSort() {
    	InsertionSort.insertionSort(array);
        
        assertEquals(array.length, sortedArray.length);		// test that the array lengths are the same

        for (int i = 0; i < array.length; i++)
        	assertEquals(array[i], sortedArray[i]);
    }     

    @Test
    public void testShellSort() {
    	ShellSort.shellSort(array);
        
        assertEquals(array.length, sortedArray.length);		// test that the array lengths are the same

        for (int i = 0; i < array.length; i++)
        	assertEquals(array[i], sortedArray[i]);
    }
    
    @Test
    public void testMergeSort() {
    	MergeSort.mergeSort(array);
        
        assertEquals(array.length, sortedArray.length);		// test that the array lengths are the same

        for (int i = 0; i < array.length; i++)
        	assertEquals(array[i], sortedArray[i]);
    }
    
    @Test
    public void testQuickSort() {
    	QuickSort.quickSort(array);
        
        assertEquals(array.length, sortedArray.length);		// test that the array lengths are the same

        for (int i = 0; i < array.length; i++)
        	assertEquals(array[i], sortedArray[i]);
    }    
    
    @Test
    public void testHeapSort() {
    	HeapSort.heapSort(array);
        
        assertEquals(array.length, sortedArray.length);		// test that the array lengths are the same

        for (int i = 0; i < array.length; i++)
        	assertEquals(array[i], sortedArray[i]);
    }   
    @Test
    public void testBucketSort() {
    	BucketSort.bucketSort(array);
        
        assertEquals(array.length, sortedArray.length);		// test that the array lengths are the same

        for (int i = 0; i < array.length; i++)
        	assertEquals(array[i], sortedArray[i]);
    }      
}
