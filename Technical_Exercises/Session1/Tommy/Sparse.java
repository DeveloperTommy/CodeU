
public class Sparse 
{

	public static void main(String[] args) 
	{
		int test1[][] = new int[][] {
				{1, 0, 3, 0, 5},
				{0, 7, 0, 4, 9},
				{0, 0, 0, 0, 1}
		};
		
		System.out.println("Test One: \n");
		condense(test1);
		
		int test2[][] = new int[][] {
				{1, 4, 3, 0, 5},
				{6, 7, 5, 4, 9},
				{7, 0, 0, 0, 3},
				{6, 7, 1, 3, 4}
		};
		
		System.out.println("\nTest Two: \n");
		condense(test2);
		
		int test3[][] = new int[][] {
				{0, 0, 0, 0, 0},
				{0, 0} 
		};
		
		System.out.println("\nTest Three: \n");		
		condense(test3);
		
		int test4[][] = new int[][] {
				{5, 0, 0, 0, 0},
				{0, 2},
				{},
				{},
				{},
				{9, 4, 2, 3, 4, 5353544, 24343, 4}
		};
		
		System.out.println("\nTest Four: \n");		
		condense(test4);
		
		
		int test5[][] = new int[][] {
				{},
				{},
				{999999, 0, -1, -5, -6, -7, -8, -903904},
				{},
				{}
		};
		
		System.out.println("\nTest Five: \n");		
		condense(test5);
		

	}
	
	public static void condense(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] != 0)
					System.out.println("[" + (i+1) + ", " + (j+1) + "]: " + matrix[i][j]);
			}
		}
	}
	

}
