import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;

public class Query implements Iterable<String> {
	//It seems like we will need to create an iterator for Query as well to get its next.
	
	Timestamp stamp;
	String list;
	int numWords;	
	
	public Query() {		
		list = "";
		numWords = 0;
	}
	
	public void add(String input) { //Does not seem like we can use string builder.
		list += (" " + input);
		numWords++;
	}	
	
	public Iterator<String> iterator() {		
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<String> {
		
		int current = 0;
		String[] words = list.split("\\s+");
		
		public boolean hasNext() {
			return current <= numWords;
		}
		
		public String next() {
			current++;
			return words[current-1];
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Not implemented");
		}
		
		
	}
	

}
