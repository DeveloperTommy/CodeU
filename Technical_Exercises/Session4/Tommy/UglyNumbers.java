
public class UglyNumbers {
	/*
	 * Ugly numbers are positive integers whose prime factors are 2, 3, or 5. The first ugly number is 1.
	 * This means that no other prime numbers are part of the ugly numbers. What we could do is iterate
	 * through the set of real numbers starting from 1 and incrementing up. We keep a counter of our current
	 * ugly number count and cache it for future use. We can then check each number as to whether or not 
	 * the number is divisible by 2, 3, or 5, and if it is, then it is an ugly number. 
	 * 
	 * However, maybe there is another way that does only one computation based on what's already cached to
	 * find the next ugly number. But how? If we simply do bottom up computations such as 2 * 2 * 2 = 8, what if
	 * we did 5 * 5 * 5, which is 125? There is definitely several more ugly numbers in between than to reach 
	 * three computations of three times a prime factor. Doing it that way produces very random numbers that will
	 * need to be sorted, and what if there is an ugly number that we missed? I think I will implement the algorithm
	 * I described in the first paragraph and then see if I can improve it later.
	 * 
	 * Okay, thinking about it more, if you take the minimum between the three multiples of 2, 3, and 5, and keep
	 * track of each multiple you are on, then you can compute the next ugly number in one computation. Also,
	 * there seems to be a flaw in the algorithm of my first paragraph. 14 is not an ugly number since it has
	 * a prime factor of 7. This holds true for other prime factors as well that are multiplied by 2, 3, or 5.
	 */

	int current, currentIdx, first, second, third;
	int[] cache;
	
	public UglyNumbers() {
		current = 1;
		currentIdx = 0;
		cache = new int[500];
		cache[currentIdx] = current;
		first = 0;
		second = 0;
		third = 0;
		
	}
	
	public int findUglyNum(int K) throws Exception {
						
		if (K > cache.length) {
			expandCache();
		}
		
		if (cache[K-1] != 0) {
			//System.out.println("Pulled from cache");
			return cache[K-1];
		}
		
		while (currentIdx < K - 1) {			
			int two = cache[first] * 2;
			int three = cache[second] * 3;
			int five = cache[third] * 5;
			
			current = min (two, three, five);
						
			
			if (current == two) {
				first++;
			}
			else if (current == three) {
				second++;
			}
			else if (current == five) {
				third++;
			}
			
			//Prevent duplicates.
			if (current != cache[currentIdx]) {
				currentIdx++;			
				cache[currentIdx] = current;
			}
						
			
		}			
		
		/*
		for (int i = 0; i < currentIdx; i++) {
			System.out.println("Debug: " + cache[i]);
		}
		*/
		
		return cache[currentIdx];
	}
	
	private void expandCache() throws Exception {
		if (cache.length * 2 > Integer.MAX_VALUE) {
			throw new Exception("Number too large");
		}			
		
		int[] oldCache = cache;
		cache = new int[oldCache.length * 2];
		
		for (int i = 0; i < oldCache.length; i++) {
			cache[i] = oldCache[i];
		}
	}
	
	public int min(int two, int three, int five) {
		if (two < three && two < five) { 
			return two;
		}
		if (three < five) {
			return three;
		}				
		return five;			
			
	}
	

}
