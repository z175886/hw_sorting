
public class MissionThree {
	public static void main(String[] args) {
		Integer[] p1 = {4,6,8,22};
		Integer[] p2 = {3,7,10,23};
		int difference = merge(p1,p2);
		System.out.println(difference);
	}

	/**
	 * Merges two sorted arrays, and computer the difference in scores
	 * 
	 * @param person1 a sorted array of medals
	 * @param person2 a sorted array of medals
	 * @return the difference in score of person1 and person2
	 */
	public static <T extends Comparable<? super T>> int merge(T[] person1, T[] person2) {
		int i = person1.length;
		int j = person2.length;
		int p1Score = 0;
		int p2Score = 0;
		int score = i + j;
		while(i > 0 && j > 0){
			if(person1[i-1].compareTo(person2[j - 1]) > 0){
				p1Score += score--;
				i--;
			}
			else{
				p2Score += score--;
				j--;
			}
		}
		while (i > 0) {
			p1Score += score--;
			i--;
		}

		while (j > 0) {
			p2Score += score--;
			j--;
		}

		return Math.abs(p1Score - p2Score);


	}
	
}
