
public class Largest {
	//For this exercise, I think we have to sort the input, but not necessarily the whole thing. Only the
	//n number of elements for the call for nth element.
	//Perhaps divide by n partitions, sort them, then take the largest of those numbers and take the largest of that
	//For now, will implement mergesort, then move onto this algorithm above.
	
	int[] numbers;
	int[] merged;
	
	public Largest (int[] input) {
		numbers = input;		
		merged = new int[numbers.length];		
		mergesort(0, numbers.length - 1);
	}
	
	public int nthLargest(int rank) throws Exception {
		if (rank > numbers.length || rank == 0)
			throw new Exception("Invalid input for method!");
		
		return numbers[rank - 1];
	}
	
	public void merge(int low, int middle, int high) {
		
		for (int i = low; i <= high; i++) {
			merged[i] = numbers[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while (i <= middle && j <= high) {
			if (merged[i] > merged[j]) {
				numbers[k] = merged[i];
				i++;
			} else {
        	numbers[k] = merged[j];
        	j++;
      }      
			k++;
		}

		while (i <= middle) {
			numbers[k] = merged[i];
      k++;
      i++;
		}	
		
	}
	
	public void mergesort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low)/2;
			
			mergesort(low, middle);
			mergesort(middle + 1, high);
			
			merge(low, middle, high);
		}
	}
	

}
