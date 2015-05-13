
public class Collection {
	//For this exercise, we assume that the values in the collection will be no more than Integer.MAX_VALUE
	//We also assume that we are given an array of integers that represent this set.
	//We want to use merge sort to sort the numbers then iterate through the set with a counter to see
	//if the collection has a majority.
	
	int numbers[];
	int merged[];
	
	public Collection(int[] input) {
		numbers = input;
		merged = new int[numbers.length];		
		mergesort(0, numbers.length - 1);
		
	}
	
	public boolean hasMajority() {
		int current = numbers[0];
		int repetitions = 1;
		int majority = numbers.length/2;
		
		for (int i = 1; i < numbers.length; i++) {
			if (current != numbers[i]) {
				repetitions = 1;
				current = numbers[i];
			}
			else {
				repetitions++;
				if (repetitions > majority)
					return true;
			}									
		}
		
		return repetitions > majority;				
	}
	
	public void merge(int low, int middle, int high) {
		
		for (int i = low; i <= high; i++) {
			merged[i] = numbers[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while (i <= middle && j <= high) {
			if (merged[i] <= merged[j]) {
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
