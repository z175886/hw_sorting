import java.util.Arrays;

public class BasicTraining {
	public static <T extends Comparable<? super T>> void main(String[] args) {
		Integer[] arr;
		 arr = new Integer[]{10, 17, 0, 19, 4, 11, 4, 15, 20, 8, 12, 16, 2, 23, 14, 18};
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * Sort the array using quick sort, this must be:
	 * 
	 * in-place (no temporary arrays)
	 * O(n log n)
	 * 
	 * @param array
	 * @return a sorted array
	 */


	public static <T extends Comparable<? super T>> void quickSort(T[] array, int low, int high){
		if(low < high)
		{
			int pi = partition(array, low, high);//find hte pivot
			quickSort(array, low, pi -1);//sort left side of the pivot
			quickSort(array, pi + 1,high);//sort right side of the pivot

		}


	}
	public static <T extends Comparable<? super T>> int partition(T array[], int low, int high){
		T pivot = array[findPivotIndex(array,low,high)];
		int i = low;
		int j = high;
		while(i < j){
			do{
				i++;
			}while(array[i].compareTo(pivot) < 0 );

			while(array[j].compareTo(pivot) > 0 ){

				j--;
			}
			if(i < j) {
				T temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		//move pivot
		T temp = array[j];
		array[j] = pivot;
		array[low] = temp;
		return j;
	}

	/**
	 * Median-of-three pivot selection
	 */
	private static <T extends Comparable<? super T>> int findPivotIndex(T[] arr, int left, int right){
		int mid = left + (right - left) / 2;
		// left > mid
		if(arr[left].compareTo(arr[mid])>0){
			// left >  mid > right
			if(arr[mid].compareTo(arr[right]) > 0 ) return mid;
			else {
				if (arr[left].compareTo(arr[right]) > 0) return right;
				else return left;
			}
		}
		// mid > left
		else{
			// mid > left > right
			if(arr[left].compareTo(arr[right]) > 0) return left;
			else{
				// mid > right > left
				if (arr[mid].compareTo(arr[right]) > 0) return right;
					// right > mid > left
				else return mid;
			}
		}

	}
	
}
