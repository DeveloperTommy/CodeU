import java.util.Iterator;
import java.util.LinkedList;


public class QueryStream implements Iterable<String>{
	
	LinkedList<Query> list;
	
	public QueryStream() {
		list = new LinkedList<Query>();
	}
	
	public void addQuery(Query input) {
		list.add(input);
	}
	
	public Iterator<String> iterator() {
		return new MyIterator();
	}
		
	
	private class MyIterator implements Iterator<String> {
						
		int index = 0;				
		boolean newQuery = false;
		@SuppressWarnings("unchecked")
		Iterator<String> current = (Iterator<String>) list.get(0).iterator();		
		
		public boolean hasNext() {		
			if (current.hasNext()) { 
				return true;
			}
																					
			while (index < list.size() && !current.hasNext()) {				
				index++;
				if (index < list.size()) {
					current = list.get(index).iterator();
				}
				newQuery = true;				
			}
			
			return index < list.size();
		}
		
		public String next() {
			if (newQuery) {
				newQuery = false;
				return "<NEWQUERY>" + current.next();
			}
			return current.next();
		}
	
		public void remove() {
			throw new UnsupportedOperationException("Method not implemented.");
			
		}
		
	}
	

}
