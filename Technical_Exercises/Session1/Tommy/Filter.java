public class Filter 
{
	// Write a function named "evens" that takes as input an array of
	// ints and returns a different array of ints containing
	// only the even elements of the input.
	
	public static int[] evens(int[] input) 
	{
		// Here are some reminders:
		//
		// You can find input's length using input.length.
		//
		// You can find the remainder of a division using %. For instance,
		// 11 % 3 -> 2
		// 25 % 4 -> 1
		//
		// You can declare a new array of integers with the syntax:
		// int[] var_name = new int[n];
		//
		// For example:
		// int[] clown = new int[10];
		// creates an array named clown of 10 integers (clown[0] through clown[9])
		//
		// STUDENTS, WRITE CODE HERE.
		
		if (input == null)
			return null;
		
		int[] sparse = new int[input.length];
		int numEvens = 0;
		
		for (int i = 0; i < input.length; i++)
		{
			if (input[i] % 2 == 0)
				sparse[numEvens++] = input[i];
		}
		
		int[] evens = new int[numEvens];
		
		for (int i = 0; i < numEvens; i++)
		{
			evens[i] = sparse[i];
		}
		
		return evens;
		
	}
	
	public static void main(String[] args) 
	{
		//
		// Expected output:
		// test1 results:
		// 8
		// 6
		// 0
		// test2 results:
		// 2
		// 18
		// 28
		// 18
		// 28
		// 90
		//
		// STUDENTS, ADD ADDITIONAL TEST CASES BELOW
		//
		
		int[] test1 = {8,6,7,5,3,0,9};
		int[] ans = evens(test1);
		
		System.out.println("test1 results:");
		
		for (int i = 0; i < ans.length; ++i) 
		{
			System.out.println(ans[i]);
		}
		
		int[] test2 = {2,7,18,28,18,28,45,90,45};
		ans = evens(test2);
		System.out.println("test2 results:");
		
		for (int i = 0; i < ans.length; ++i) 
		{
			System.out.println(ans[i]);
		}
		
		int[] test3 = {2, 4, 6, 8, 10, 12}; //Expected: the same array
		ans = evens(test3);
		System.out.println("test3 results:");
		
		for (int i = 0; i < ans.length; ++i) 
		{
			System.out.println(ans[i]);
		}
		
		int[] test4 = {-2, -4, 5, -8, -10, -12}; //Expected: the same array except 5
		ans = evens(test4);
		System.out.println("test4 results:");
		
		for (int i = 0; i < ans.length; ++i) 
		{
			System.out.println(ans[i]);
		}
		
		int[] test5 = {3, 5, 7, 9, 11, 13}; //Expected: nothing or null
		ans = evens(test5);
		System.out.println("test5 results:");
		
		for (int i = 0; i < ans.length; ++i) 
		{
			System.out.println(ans[i]);
		}
		
		int[] test6 = {2, -2, 4, -7, -8000, 1}; //Expected: 2, -2, 4, -8000
		ans = evens(test6);
		System.out.println("test6 results:");
		
		for (int i = 0; i < ans.length; ++i) 
		{
			System.out.println(ans[i]);
		}
	}
}