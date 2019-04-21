/**
	MergeSort - algorithm for sorting
*/
import java.util.List;
import java.util.ArrayList;

public class MergeSort {
	public static void main (String[] args){
		ArrayList<Integer> array = new ArrayList<Integer>();


		array.add(3);
		array.add(2);
		array.add(5);
		array.add(1);
		array.add(6);
		System.out.println("Before: ");	
		showArray(array);
		System.out.println("Sorting the array using mergesort...");
		System.out.println("After: ");
		sort(array);
		showArray(array);
	}

	public static List<Integer> sort(List<Integer> array) {
		List<Integer> result = null;
		
		if (array.size() <= 1){
			return array;
		}else{


			int mid = array.size() / 2;
        	List<Integer> leftArray = new ArrayList<Integer>();
			List<Integer> rightArray = new ArrayList<Integer>();

			leftArray = array.subList(0,mid);
			System.out.println("LEFT SORTING");
			showArray(leftArray);
			rightArray = array.subList(mid, array.size());
			System.out.println("RIGHT SORTING");
			showArray(rightArray);

			leftArray = sort(leftArray);
			rightArray = sort(rightArray);

			result = merge(leftArray, rightArray, array);
		}
		return result;
	}

	public static List<Integer> merge(List<Integer> leftArray, List<Integer> rightArray, List<Integer> array){
		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		int arrayIndex = 0;
		
		List<Integer> restArray = new ArrayList<>();
		int restArrayIndex = 0;

		while (leftArrayIndex < leftArray.size() && rightArrayIndex < rightArray.size()) {
			if (leftArray.get(leftArrayIndex).compareTo(rightArray.get(rightArrayIndex)) <= 0){
				array.set(arrayIndex,leftArray.get(leftArrayIndex));
				leftArrayIndex++;
			}else{
				array.set(arrayIndex,rightArray.get(rightArrayIndex));
				rightArrayIndex++;
			}
			arrayIndex++;
		}

		if (leftArrayIndex >= leftArray.size()){
			restArray = rightArray;
			restArrayIndex = rightArrayIndex;
		}else{
			restArray = leftArray;
			restArrayIndex = leftArrayIndex;
		}

        for(int i = restArrayIndex; i  < restArray.size();i++){
			array.set(arrayIndex, restArray.get(i));
			arrayIndex++;
		}

		return array;

	}

	public static void showArray(List<Integer> array){
		for (int i = 0; i < array.size();i++){
			System.out.print(array.get(i)+ " ");
		}
		System.out.println("");
	}
}


