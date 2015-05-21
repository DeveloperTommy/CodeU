import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;


public class Segmenter {
	/*
	 * So we want to be able to separate words based on a given dictionary. What comes to mind to me
	 * is creating a hash value for each word in the dictionary. For this problem, I'm going to assume 
	 * that the given string contains words found in a dictionary and there are no invalid words. 
	 * 
	 * I can create a current pointer that takes the product of the the number of letters equal to the largest
	 * word(s) in the dictionary and work backwards to match the hash value. That way, smaller words contained
	 * in larger words of the dictionary won't be mistakenly matched. 
	 * 
	 */
	
	LinkedList<String>[] table;
	private final int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
	LinkedList<Integer> lengths;
	
	@SuppressWarnings("unchecked")
	public Segmenter(String[] dictionary) {
		table = new LinkedList[101 * 6]; //Average word length is just over 5.
		lengths = new LinkedList<Integer>();
		
		for (int i = 0; i < dictionary.length; i++) {
			BigInteger hash = new BigInteger("1");
			for (int j = 0; j < dictionary[i].length(); j++) {
				hash.multiply(new BigInteger(Integer.toString(primes[(int) dictionary[i].charAt(j) - 'a'])));				
			}
			hash.mod(new BigInteger(Integer.toString(table.length)));
			if (table[hash.intValue()] == null) {
				table[hash.intValue()] = new LinkedList<String>();
			}
			table[hash.intValue()].add(dictionary[i]);
			
			if (!lengths.contains(dictionary[i].length())) {
				lengths.add(dictionary[i].length());
			}
		}				
		
		Collections.sort(lengths); //This sort is a modified mergesort per Java api.
		Collections.reverse(lengths); //Put list of lengths in descending order for code clarity in following method
		
	}
	
	public String getSegmented(String input) {
		
		int currentIdx = 0;
		StringBuilder segment = new StringBuilder();
		
		while (currentIdx < input.length()) {
		
			for (Integer length: lengths) {
				if (currentIdx + length <= input.length()) {	
				
					BigInteger hash = new BigInteger("1");
					for (int j = currentIdx; j < length; j++) {
						hash.multiply(new BigInteger(Integer.toString(primes[(int) input.charAt(j) - 'a'])));				
					}
					hash.mod(new BigInteger(Integer.toString(table.length)));								
														
					String currentString = input.substring(currentIdx, currentIdx + length);
										
					if (table[hash.intValue()] != null) {
						if (table[hash.intValue()].contains(currentString)) {
							segment.append(currentString + " ");
							currentIdx += length;
							break;
						}
					}				
				}
			}
		}
		
		return segment.toString();		
	}

}
