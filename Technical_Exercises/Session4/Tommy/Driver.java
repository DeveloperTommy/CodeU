
public class Driver {

	public static void main(String[] args) throws Exception {
		
		/***** Bit Palindrome TESTING *****/
		
		BitPalindrome bTester = new BitPalindrome();
		
		System.out.println(bTester.getPalindrome(1)); //Expected: 1
		System.out.println(bTester.getPalindrome(3)); //Expected: 5
		System.out.println(bTester.getPalindrome(4)); //Expected: 7
		System.out.println(bTester.getPalindrome(5)); //Expected: 9
		
		//Boundary Checking
		System.out.println(bTester.getPalindrome(5000)); 
		System.out.println(bTester.getPalindrome(5001));
		
		try {
			System.out.println(bTester.getPalindrome(0));
		}
		catch (Exception e) {
			System.out.println("Passes 0 boundary test");					
		}
		
		bTester = new BitPalindrome();				
		System.out.println(bTester.getPalindrome(49)); 		
		
		/***** END OF Bit Palindrome TESTING *****/
		
		
		
		/***** Longest Palindrome Subsequence TESTING *****/
		
		LongestPalindrome pTester = new LongestPalindrome();
		
		pTester.findLongPalindrome("12111122221212121"); 
		//Expected: Start Index: 9, Length: 7, Sequence: "2121212"
		pTester.findLongPalindrome("BEEAEEP"); 
		//Expected: Start Index: 1, Length: 5, Sequence: "EEAEE"
		pTester.findLongPalindrome("");
		//Expected: Start Index: 0, Length: 0, Sequence: ""
		
		/***** END OF Longest Palindrome Subsequence TESTING *****/
		
		
		/***** Ugly Numbers TESTING *****/
		UglyNumbers uglyTest = new UglyNumbers();			
		
		
		
		System.out.println(uglyTest.findUglyNum(10)); //Expected: 12
		System.out.println(uglyTest.findUglyNum(9)); //Expected: 10
		System.out.println(uglyTest.findUglyNum(8)); //Expected: 9
		System.out.println(uglyTest.findUglyNum(7)); //Expected: 8
		System.out.println(uglyTest.findUglyNum(11)); //Expected: 15
		System.out.println(uglyTest.findUglyNum(12)); //Expected: 16
		System.out.println(uglyTest.findUglyNum(13)); //Expected: 18
		
		/***** END OF Ugly Numbers TESTING *****/
		
		
		/***** Segmenter TESTING *****/
		
		Segmenter tSegment = new Segmenter(new String[] {"cat", "bat", "rat"});		
		System.out.println("Did you mean: " + tSegment.getSegmented("batcatratrat") + "?");
		//Expected: Did you mean: bat cat rat rat ?
		
		tSegment = new Segmenter(new String[] {"chat", "at", "mat"});		
		System.out.println("Did you mean: " + tSegment.getSegmented("chatchatatmat") + "?");
		//Expected: Did you mean: chat chat at mat ?
		
		tSegment = new Segmenter(new String[] {"a", "b", "c", "abc"});		
		System.out.println("Did you mean: " + tSegment.getSegmented("ababccabc") + "?");
		//Expected: Did you mean: a b abc c abc ?
		
		tSegment = new Segmenter(new String[] {"o", "oo", "ooo", "p"});		
		System.out.println("Did you mean: " + tSegment.getSegmented("poopopoopoooo") + "?");
		//Expected: Did you mean: p oo p o p oo p ooo o ?
		
		/***** END OF Segmenter TESTING *****/
		
		
	}

}
