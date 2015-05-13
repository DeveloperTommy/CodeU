
public class Driver {

	public static void main(String[] args) throws Exception {
		
		/***** TRIVIAL DICTIONARY TEST *****/
		
		TrivialDictionary dictionary = new TrivialDictionary();
		
		dictionary.add("Awards");
		dictionary.add("Strings");
		dictionary.add("Tablets");
		dictionary.add("Macs");
		
		System.out.println(dictionary.wordAt(0)); //Expected : Awards
		System.out.println(dictionary.wordAt(1)); //Expected : Strings
		System.out.println(dictionary.isInDictionary("Macs")); //Expected: true
		System.out.println(dictionary.wordAt(0)); //Expected : Macs
		System.out.println(dictionary.wordAt(1)); //Expected : Awards
		
		/***** END OF TRIVIAL DICTIONARY TEST *****/
		
		
		/***** COLLECTION TEST *****/
		
		int[] majoritySet = {2,3,3,3,3,4,5};
		int[] majoritySet2 = {2};
		
		int[] notMajoritySet = {1,2,3,4,5,6};
		int[] notMajoritySet2 = {2,3,3,3,4,4,5};
		int[] notMajoritySet3 = {2,3};
		
		Collection majority = new Collection(majoritySet);
		Collection majority2 = new Collection(majoritySet2);
		
		Collection notMajority = new Collection(notMajoritySet);
		Collection notMajority2 = new Collection(notMajoritySet2);
		Collection notMajority3 = new Collection(notMajoritySet3);
		
		System.out.println(majority.hasMajority()); //Expected: true
		System.out.println(majority2.hasMajority()); //Expected: true
		
		
		System.out.println(notMajority.hasMajority()); //Expected: false
		System.out.println(notMajority2.hasMajority()); //Expected: false
		System.out.println(notMajority3.hasMajority()); //Expected: false
		
		/***** END OF COLLECTION TEST *****/
		
	
		/***** LARGEST NTH TEST *****/			
		
		int[] test = {2, 3, 4, 5, 6, 7, 8, 9};
		int[] test2 = {1,1,1,1,1,1,9};
		
		Largest pass = new Largest(test);	
		Largest pass2 = new Largest(test2);
		
		System.out.println(pass.nthLargest(1)); //Expected: 9
		System.out.println(pass2.nthLargest(1)); //Expected: 9
		System.out.println(pass2.nthLargest(2)); //Expected: 1 
		System.out.println(pass2.nthLargest(7)); //Expected: 1 - Boundary case
		//System.out.println(pass2.nthLargest(8)); //Expected: Throws Exception
		//System.out.println(pass2.nthLargest(0)); //Expected: Throws Exception
		
		/***** END OF LARGEST NTH TEST *****/
		
		
		/***** 	QUERYSTREAM TEST *****/
		
		Query dogs = new Query();
		dogs.add("GoldenRetriever");
		dogs.add("Daschund");
		dogs.add("Pomeranian");
		dogs.add("Husky");
		dogs.add("GermanShepard");
		
		Query cats = new Query();
		cats.add("Siamese");
		
		Query hats = new Query();
		hats.add("Fedora");
		hats.add("Tophat");
		hats.add("Flat-cap");
		
		Query none = new Query();
		
		Query siblings = new Query();
		siblings.add("Sister");
		
		QueryStream qStream = new QueryStream();
		
		qStream.addQuery(dogs);
		qStream.addQuery(cats);
		qStream.addQuery(hats);
		qStream.addQuery(none);
		qStream.addQuery(siblings);
		
		for (String thing: qStream) {
			System.out.println(thing);
		}
		/** Expected Output: 
		 * 
		 *  GoldenRetriever
				Daschund
				Pomeranian
				Husky
				GermanShepard
				<NEWQUERY>
				Siamese
				<NEWQUERY>
				Fedora
				Tophat
				Flat-cap
				<NEWQUERY>
				<NEWQUERY>
				Sister
		 */
		
		
		
		/***** 	END OF QUERYSTREAM TEST *****/
		
		
		
	}

}
