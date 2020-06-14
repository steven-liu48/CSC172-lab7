import java.util.Arrays;

//Lab 7
//Lab Partners:

//Xiaoxiang "Steven" Liu
//xliu102@u.rochester.edu
//MW 6:15PM - 7:30PM

//Grant Yap
//gyap@u.rochester.edu
//MW 2:00 - 3:15PM

public class HeapTest {
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {5, 18, 3, 25, 27, 45, 97, 88, 26, 16, 49, 67};
		Heap.heapify(arr);
		System.out.println(Arrays.toString(arr));
		
		Integer[] arr2 = new Integer[] {15, 99, 3, 77, 27, 45, 7, 88, 26, 5};
		Heap.heapsort(arr2);
		System.out.println(Arrays.toString(arr2));
	}
}
