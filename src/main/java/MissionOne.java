
public class MissionOne {
	public static void main(String[] args) {
		Integer array [] = {9,1,8,2,7,3,6,5,4};
		inplaceSort(array);
		for(Integer num : array ){
			System.out.println(num);
		}
	}

	/**
	 * Sort the array using an in-place sort, this algorithm must be:
	 * 
	 * in-place (no temporary arrays)
	 * stable
	 * O(n^2)
	 * 
	 * @param array
	 * @return array sorted
	 */
	public static <T extends Comparable<? super T>> T[] inplaceSort(T[] array) {

		insertionSort(array, 0, array.length - 1);
		return array;
	}

	private static  <T extends Comparable<? super T>> void insertionSort(T[] array, int left, int right) {
		for(int i = 1; i < array.length; i++){
			T temp =  array[i];
			int j = i-1;

			while(j >= 0 && array[j].compareTo(temp) > 0 ){
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}


}
