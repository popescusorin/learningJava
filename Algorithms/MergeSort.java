/**
	MergeSort - algorithm for sorting
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class MergeSort {
	public static void main (String[] args){
		ArrayList<Integer> array = new ArrayList<Integer>();

		array.add(3);
		array.add(2);
		array.add(5);
		array.add(1);
		array.add(6);

		sort(array);
	}

	public static List<Integer> sort(List<Integer> array) {
		List<Integer> result = new ArrayList<Integer>();
		
		if (array.size() <= 1){
			return array;
		}

		int mid = array.size() / 2;
                List<Integer> leftArray = new ArrayList<Integer>();
		List<Integer> rightArray = new ArrayList<Integer>();

		leftArray = array.subList(0,mid);
		System.out.println("Left Array: " + leftArray.size());
		rightArray = array.subList(mid,array.size());
		System.out.println("Right Array: " + rightArray.size());

		leftArray = sort(leftArray);
		rightArray = sort(rightArray);

		/*if(leftArray.get(leftArray.size() - 1) <= rightArray.get(rightArray.get(0))){
			System.arraycopy(rightArray, 0, leftArray,leftArray.size(),rightArray.size());
			return leftArray;
		}*/

		result = merge(leftArray, rightArray);
		return merge(leftArray, rightArray);
	}

	public static List<Integer> merge(List<Integer> leftArray, List<Integer> rightArray){
		List<Integer> result = new ArrayList<Integer>();
		Iterator<Integer> leftIterator = leftArray.iterator();
		Iterator<Integer> rightIterator = rightArray.iterator();
		System.out.println(" M Left Array : " + leftArray.size());
		System.out.println(" M Right Array : " + rightArray.size());

		while (leftArray.size() > 0  && rightArray.size() > 0) {

			if(leftArray.get(0) <= rightArray.get(0)){
				result.add(leftArray.get(0));
				leftArray.remove(0);
			}else{
			   	result.add(rightArray.get(0));
				rightArray.remove(0);	
			}
		}

		if(leftArray.size() > 0) {
			System.arraycopy(leftArray, 0, result, result.size(), leftArray.size());
		}

		if(rightArray.size() > 0){
			System.arraycopy(rightArray, 0, result, result.size(), rightArray.size());
		}

		return result;
	}
}


