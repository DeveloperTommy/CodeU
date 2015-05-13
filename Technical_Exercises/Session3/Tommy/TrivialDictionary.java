import java.util.LinkedList;

public class TrivialDictionary {
	//For this problem we are using a linkedlist implementation since we do not know the size of the input
	//If we did know the size of the input, we could implement this using hash tables which will allow
	//for fast dictionary operations to occur - O(1).

	static LinkedList<String> dictionary;
    
	public TrivialDictionary() {
		dictionary = new LinkedList<String>();
	}
    
  public static String wordAt(int idx) {
  	if (idx >= dictionary.size()) {
  		return null;
  	}
  	
  	return dictionary.get(idx);  		
  }
  
  public boolean isInDictionary(String input) {
  	String head;
  	boolean status = false;
  	
  	for (String current: dictionary) {
  		if (current.equals(input)) {
  			status = true;
  			head = current;
  			dictionary.remove(current);
  			dictionary.offerFirst(head);
  		}
  	}
  	
  	return status;
  }
  
  public void add(String input) {
  	dictionary.add(input);
  }
  
  public void remove(String input) {
  	dictionary.remove(input);
  }

}
