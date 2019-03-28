/**
* Sorting an array using the bubbleSort algorithm
*/

public class bubbleSort {
	
	static private int [] intArray = new int[] {5,2,1,4,3,6};


	public static void  main (String [] args){
		intArray = sortArray(intArray);
		printArray(intArray);
	}

	private static final int[] sortArray(int [] array){
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array.length - 1 - i; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}

	private static final void printArray(int [] array) {
		for (int i : array){
			System.out.println(i);
		}
	}
}


