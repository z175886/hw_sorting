import java.sql.Array;

public class MissionTwo<T extends Comparable<? super T>> {
	public static void main(String[] args) {
		MissionTwo arr = new MissionTwo(6);
		arr.add(3);
		arr.add(2);
		arr.add(1);
		arr.add(4);
		arr.add(9);
		arr.add(0);
		for (int i=0;i< arr.numOfItem;i++){
			System.out.println(arr.getArray()[i]);
		}
		arr.remove();
		arr.remove();
		arr.remove();
		for (int i=0;i< arr.numOfItem;i++){
			System.out.println(arr.getArray()[i]);

		}
	}

	private T[] data;
	private  int numOfItem;
	private int maxCapacity;

	
	/**
	 * Default Constructor
	 */
	public MissionTwo(int maxCapacity) {
		 this.data = (T[]) new Comparable[maxCapacity];
		 this.maxCapacity = maxCapacity;
		 int numOfItem = 0;
	}
	
	/**
	 * Adds the item to the structure, must be
	 * 
	 * in-place
	 * stable
	 * O(n)
	 * 
	 * @param item
	 */
	public void add(T item) {
		// TODO Method
		if(numOfItem < maxCapacity) {
			if (numOfItem == 0) {
				data[0] = item;
				numOfItem++;
				return;
			}
			data[numOfItem] = item;
			int j = numOfItem;
			T temp = data[j];
			int i = j - 1;
			while (i >= 0 && data[i].compareTo(temp) < 0) {
				data[i + 1] = data[i];
				i--;
			}
			data[i + 1] = temp;

			numOfItem++;
		}
		else{
			System.out.println("Array is full, not able to add item");
		}
	}
	
	/**
	 * This must return the smallest element in this structure, must be
	 * 
	 * in-place
	 * stable
	 * O(1)
	 * 
	 * @return the smallest element currently in this structure
	 */
	public T remove() {
		T tem = data[numOfItem-1];
		data[numOfItem-1] = null;
		numOfItem--;
		return tem;
	}
	//method for testing
	public T[] getArray(){
		return data;
	}
}
