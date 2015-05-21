
public class BitPalindrome {
	/*
	 * Some notes before coding:
	 * Since I will be ignoring leading 0's for the Palindrome with bits problem,
	 * I can quickly eliminate even numbers since their binary representation will always be 
	 * something like 10 or 100 or 1000 or 10010. There will always be a 0 at the end and a 1
	 * at the beginning since it is some form of the power of 2.
	 * 
	 * This means I only have to worry about odd numbers. Also, I think I can cache my results
	 * for numbers less than the K'th positive integer for quick recovery. Essentially to test if it is
	 * a palindrome, I can take a binary string representation and make sure the first half matches the 
	 * last half. This is most likely an O(n/2) operation, but perhaps there is a faster way to compute 
	 * that is specific to the bits. Will add onto this if I discover it. Seems to me this will be 
	 * an O(n^2) algorithm since we have to compute from the bottom up, until our cache is filled.
	 */
	
	int[] cache;
	int lastK;
	
	public BitPalindrome() {
		cache = new int[5000];	
		cache[0] = 1;
		lastK = 0;
	}
	
	public int getPalindrome(int K) throws Exception {					
		if (K >= cache.length || K < 1) {
			if (2 * K > Integer.MAX_VALUE) {
				throw new Exception("Integer out of bounds. Please input valid integer");
			}
			
			int[] oldcache = cache;
			cache = new int[K * 2];
			
			for (int i = 0; i < oldcache.length; i++) {
				//System.out.println("Pulled from cache");
				cache[i] = oldcache[i];
			}			
		}
		
		if (cache[K-1] != 0) {
			return cache[K-1];
		}
		
		while (lastK != K) { //We actually are doing one more computation than we actually need, but doing this is cleaner code. And it will be cached.
			int current = cache[lastK] + 2; //Skip even integers
						
			boolean found = false;
			String toBinary;
			
			while (!found) {
				toBinary = Integer.toBinaryString(current);
				boolean palindrome = true;
				
				for (int i = 0; i < toBinary.length()/2; i++) {
					if (toBinary.charAt(i) != toBinary.charAt(toBinary.length() - i - 1)) {
						palindrome = false;
					}
				}
				
				if (palindrome) {
					lastK++;
					cache[lastK] = current;
					found = true;
				}
				else {
					current = current + 2;
				}				
			}					
			
		}
	
		return cache[K-1];
	}
	
	

}
