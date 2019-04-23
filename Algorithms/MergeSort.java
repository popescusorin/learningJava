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
		System.out.println("Before: ");	
		showArray(array);
		System.out.println("After: ");
		array = sort(array);
		showArray(array);
	}

	public static <E extends Comparable<? super E>> List<E> sort(List<E> array) {
		if (array.size() <= 1){
			return array;
		}

		int mid = array.size() / 2;
		List<E> leftArray = array.subList(0,mid);
		List<E> rightArray = array.subList(mid, array.size());

		leftArray = sort(leftArray);
		rightArray = sort(rightArray);
	    List<E> result = merge(leftArray, rightArray);
		
		return result;
	}

	public static <E extends Comparable<? super E>> List<E> merge(List<E> leftArray, List<E> rightArray){
		
		List<E> result = new ArrayList<E>();
		Iterator <E> leftArrayIterator = leftArray.iterator();
		Iterator <E> rightArrayIterator = rightArray.iterator();

		E leftIterator = leftArrayIterator.next();
		E rightIterator = rightArrayIterator.next();

		while (true) {
			if (leftIterator.compareTo(rightIterator) <=0){
				result.add(leftIterator);
				if(leftArrayIterator.hasNext()){
					leftIterator = leftArrayIterator.next();	
				}else{
					result.add(rightIterator);
					while(rightArrayIterator.hasNext()){
						result.add(rightArrayIterator.next());
					
					}
					break;
				}

			}else{
				result.add(rightIterator);
				if (rightArrayIterator.hasNext()){
					rightIterator = rightArrayIterator.next();
				}else{
					result.add(leftIterator);
					while(leftArrayIterator.hasNext()){
						result.add(leftArrayIterator.next());	
				    }
					break;
				}
			}
		}
		return result;
	}

	public static void showArray(List<Integer> array){
		for (int i = 0; i < array.size();i++){
			System.out.print(array.get(i)+ " ");
		}
		System.out.println("");
	}
}


