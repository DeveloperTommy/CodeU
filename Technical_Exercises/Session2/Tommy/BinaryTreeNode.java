
public class BinaryTreeNode {
    
    private BinaryTreeNode left, right;
    private String payload;    
    
    public BinaryTreeNode(String input) {	
	left = null;
	right = null;
	payload = input;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
    

}
