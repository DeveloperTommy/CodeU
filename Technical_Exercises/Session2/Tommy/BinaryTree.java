import java.util.LinkedList;
import java.util.List;

public class BinaryTree { 
    
    //Not exactly sure if I'm allowed to use an array implementation of a binary tree so I'm just going to use nodes
    
    private static BinaryTreeNode root;
    private int numElements;
    
    public BinaryTree () {
	root = null;
	numElements = 0;
    }
    
    public static void main(String[] args) {
	build();
	
	List<String> iterate = flatten();
	
	for (String thing : iterate) {
	    System.out.println(thing);
	}
    }
    
    public static void build() {
	root = new BinaryTreeNode("The Root");		

	BinaryTreeNode left, right;
	
	left = root;
	right = root;
	
	//This builds a tree with the left child only having left children and right child only have right children
	for (int i = 1; i < 50; i++) {	    
	    left.setLeft(new BinaryTreeNode("Level " + i + " Left Node"));
	    left = left.getLeft();
	    
	    right.setRight(new BinaryTreeNode("Level " + i + " Right Node"));
	    right = right.getRight();
	}
	
    }
    
    public static List<String> flatten() { //Flattens the tree for pre-order traversal.
	List<String> flattened = new LinkedList<String>();
	flattenHelper(root, flattened);
	
	return flattened;
    }
    
    private static void flattenHelper(BinaryTreeNode input, List<String> list) {
	if (input == null) {
	    return;
	}
	
	list.add(input.getPayload());
	flattenHelper(input.getLeft(), list);
	flattenHelper(input.getRight(), list);
    }

}
