//Lab 7
//Lab Partners:

//Xiaoxiang "Steven" Liu
//MW 6:15PM - 7:30PM

//Grant Yap
//MW 2:00 - 3:15PM

public class Heap {
	public static void heapify(Integer[] arr) {
		for(int i = arr.length/2 - 1; i >= 0; i--) {
			siftdown(arr, i);
		}
	}
	public static void heapsort(Integer[] arr) {
		Integer[] temp = new Integer[arr.length];
		heapify(arr);
		for(int i = 0; i < arr.length; i++) {
			temp[arr.length - i - 1] = arr[0];
			//System.out.println(i + " " + temp[i]);
			arr[0] = 0;
			siftdown(arr, 0);
		}
		for(int i = 0; i < arr.length; i++) {
			arr[i] = temp[i];
		}
	}
	
	public static void siftdown(Integer[] arr, int pos) {
		assert pos >= 0 && pos < arr.length : "Illegal Position";
		while(!isleaf(arr, pos)) {
			int j = pos * 2 + 1;
			if( j + 1 < arr.length) {
			if(arr[j] < arr[j + 1]) {
				j = j + 1;
			}
			}
			if(arr[j] <= arr[pos]) {
				return;
			}
			int temp = arr[pos];
			arr[pos] = arr[j];
			arr[j] = temp;
			//Move down
			pos  = j;
		}
	}
	
	public static boolean isleaf(Integer[] arr, int pos) {
		return(pos >= arr.length/2) && (pos < arr.length);
	}
}
