
class Zip 
{
	
	// Fill in the method "join". It returns a boolean array. The ith
	// value is that array (i.e., array[i]) should be true if the ith
	// value in the first argument to join is divisible by the ith value
	// in the second argument to join. ***The returned boolean array should
	// be exactly as long as the shorter of the two arguments.
	//
	// Reminders:
	//
	// 1. An integer p is said to be "divisible by" an integer q when there
	// is some integer k such that q*k = p. This is the same as saying
	// "the remainder of p when divided by q is 0". The remainder
	// operator is Java is written with a percent sign: "a % b" is the
	// remainder of a when divided by b.
	//
	// 2. The length of an array bar is stored in bar.length.
	//
	// 3. New arrays are declared with the syntax:
	// float[] foo = new float[8];
	//
	
	static boolean[] join(int[] y, int[] z) 
	{
		boolean[] joined = null;
		
		if (y == null || z == null)
			return joined;
		
		// STUDENTS: WRITE YOUR CODE HERE!
		if (y.length < z.length)
		{
			joined = new boolean[y.length];
			
			for (int i = 0; i < y.length; i++)
			{
				if (z[i] != 0 && y[i] % z[i] == 0)
					joined[i] = true;
			}
		}
		else
		{
			joined = new boolean[z.length];
			
			for (int i = 0; i < z.length; i++)
			{
				if (z[i] != 0 && y[i] % z[i] == 0)
					joined[i] = true;
			}
		}
		
		return joined;
	}
	
	public static void main(String[] args) 
	{
		
		//
		// Expected output:
		// false
		// false
		// false
		// false
		// true
		// false
		// true
		//
		// STUDENTS, ADD ADDITIONAL TEST CASES BELOW
		//
	
		int euler[] = {2, 7, 18, 28, 18, 28, 45, 90, 45};
		int jenny[] = {8, 6, 7, 5, 3, 0, 9};
		boolean divisibles[] = join(euler, jenny);
		for (int i = 0; i < divisibles.length; ++i) 
		{
			System.out.println(divisibles[i]);
		}
		
		System.out.println("\nStudent Test Cases:");		
		
		int zeros[] = {0, 0, 0, 0, 0, 0, 0, 0};
		int threes[] = {3, 6, 9, 12, 15, 18, 21, 24};
		int negatives[] = {-4, -2, -6, -7, -3, -7, -4};
		int evens[] = {2, 4, 6, 8, 10, 12};
		
		boolean testOne[] = join(zeros, threes); //Expected output: All true
		boolean testTwo[] = join(threes, zeros); //Expected output: All false
		boolean testThree[] = join(threes, negatives); //Expected output: false, true, false, false, true, false, false 
		boolean testFour[] = join(negatives, evens); //Expected output: true, false, true, false, false, false
		
		System.out.println("\nTest One:");	
		for (int i = 0; i < testOne.length; ++i) 
		{
			System.out.println(testOne[i]);
		}
		
		System.out.println("\nTest Two:");	
		for (int i = 0; i < testTwo.length; ++i) 
		{
			System.out.println(testTwo[i]);
		}
		
		System.out.println("\nTest Three:");	
		for (int i = 0; i < testThree.length; ++i) 
		{
			System.out.println(testThree[i]);
		}
		
		System.out.println("\nTest Four:");	
		for (int i = 0; i < testFour.length; ++i) 
		{
			System.out.println(testFour[i]);
		}
		
		
	}
}