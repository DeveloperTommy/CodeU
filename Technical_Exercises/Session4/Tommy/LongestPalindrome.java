
public class LongestPalindrome {
	/*
	 * We are trying to find the longest palindrome subsequence of a string. For this problem
	 * I think I am going to try to break things down from the bottom up. Trivial cases are
	 * empty strings and single characters which are palindromes. A two letter string is a palindrome
	 * if both characters are the same letter.	 
	 * 
	 * If we cache our results in a table specific to a string, we can build/fill a table of results for
	 * palindromes of that string. We can use i and j as the start and end indexes for the string. To 
	 * fill i and j for string lengths greater than 2, we can check if table[i + 1, j - 1] was true. If it was,
	 * and string[i] = string[j], then table[i][j] is true.  
	 */
	
	
	public void findLongPalindrome(String input) {
		int size = input.length();
		boolean table[][] = new boolean[size][size];
		
		int start = 0;
		int max = 0;	
		
		for (int i = 0; i < size; i++) {
			table[i][i] = true;
		}
		
		boolean first = true;
		
		for (int i = 0; i < size - 1; i++) {
			if (input.charAt(i) == input.charAt(i+1)) {
				if (first) {
					first = false;
					start = i;
				}
				max = 2;
				table[i][i+1] = true;
			}
		}
		
		for (int k = 3; k < size; k++) {
			
			first = true;
			
			for (int i = 0; i < size - k; i++) {
				int j = k + i - 1;
				
				if (table[i+1][j-1] && input.charAt(i) == input.charAt(j)) {
					table[i][j] = true;
					if (first) {
						start = i;
						first = false;
					}
					max = k;
				}
				
			}
			
		}			
		
		System.out.println("The starting index of the longest palindrome subsequence is: " + start);
		System.out.println("The length of the longest palindrome subsequence is: " + max);
		System.out.println("The longest palindrome subsequence is: " + input.substring(start, start + max));
		
	}
	
	

}
