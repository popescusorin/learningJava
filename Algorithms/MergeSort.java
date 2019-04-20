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

		sort(array);
	}

	public static ArrayList<Integer> sort(ArrayList<Integer> array) {
		
		if (array.size() < 1){
			return array;
		}

		int mid = array.size() / 2;
        List<Integer> leftArray = new ArrayList<Integer>();
		List<Integer> rightArray = new ArrayList<Integer>();

		leftArray = array.subList(0,mid);
		rightArray = array.subList(mid,array.size());
        

		return array;
	}
}


