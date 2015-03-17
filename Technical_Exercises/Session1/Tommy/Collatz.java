class Collatz 
{
	// Consider a sequence of positive integers starting with x. If x is
	// even, the next integer in the sequence is x/2. If x is odd, the
	// next integer in the sequence is 3*x+1. The sequence stops when it
	// reaches 1.
	//
	// For example, if x is 7, the sequence is
	//
	// 7,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1
	//
	// Fill in the function loopCount so that it returns the length of
	// the sequence starting from x.
	
	static int loopCount(int x) 
	{		
		// STUDENTS: FILL IN CODE HERE!
		int current = x;
		int count = 1;
		
		while (current != 1)
		{
			if (current % 2 == 0)
				current /= 2;
			else
				current = 3 * current + 1;
			count++;
		}
		
		return count;
	}
	
	// Using loopCount, fill in the function maxLoop so that it returns
	// the maximum sequence length for any sequence that starts with a
	// number greater than or equal to x and less than y.
	
	static int maxLoop(int x, int y) 
	{
		// STUDENTS: FILL IN CODE HERE!
		// Implementing this naively. There must be a better way to do this.
		
		int max = 0;
		int current = 0;
		
		for (int i = x; i < y; i++)
		{
			current = loopCount(i);
			if (current > max)
				max = current;
		}
		
		return max;
		
	}
	
	public static void main(String[] args) 
	{
		//This implementation does not work for negative numbers
		System.out.println(loopCount(7));
		System.out.println(maxLoop(1,100000));
	}
}