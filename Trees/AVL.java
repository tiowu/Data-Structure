package uniqueAVL;

public class AVL {
	private AVLNode root;
	
	AVL(){
		root = null;
	}
	
	//erase the old tree when reading the next line
	public void delete() {
		root = null;
	}
	
	//calls the private insert method
	public void insert(AVLNode n) {
		root = insert(root, n);
		
	}
	private static AVLNode insert(AVLNode t, AVLNode node) {
		if(t == null) {
			t = node;		//insert when you reach the end (null)
		}
		else {
			if(t.data > node.data) { //go left
				t.left = insert(t.left, node); //"glue the tree together"
				t.left.parent = t;	//Identify the parent of the new node
				t.leftHeight++;		//increase the left height of the node
				updateHeight(t);	//update the node to the new height
			}
			else if (t.data < node.data) { //go right
				t.right = insert(t.right, node); //"glue the tree together"
				t.right.parent = t;
				t.rightHeight++;
				updateHeight(t);
			}
		}
		
		if(getBalance(t) == 2) {	//check for imbalance AVL
			if(getBalance(t.left) == 1) { //(2,1) case only rotate right
				t = rightRotate(t);
			}
			else if(getBalance(t.left) == -1) { //(2,-1) case rotate left then right
				t.left = leftRotate(t.left);
				t = rightRotate(t);
			}	
		}
		else if(getBalance(t) == -2) {
			if(getBalance(t.right) == -1)//(-2,-1) case only rotate left
				t = leftRotate(t);
			else if(getBalance(t.right) == 1) {//(-2,1) case only rotate right then left
				t.right = rightRotate(t.right);
				t = leftRotate(t);
			}
		}
		
		return t; //return the node so that the tree "glues" back together
	} 
//	1. rotate right at 7    		|  2. rotate left at 5 then right at 7  
//			7						    7								
//		      /  \					  	  /   \
//		    5     null                                          5     null
//		   /						       / \
//		 3						    null   3
	
//	1. rotate left at 7                     |  2. rotate right at 5 then left at 7  
//			7						     7								
//  	              /	  \					  	   /   \
//                 null    5                                            null    5
//                          \						       / \
//                           3						     3    null

	
	public static AVLNode rightRotate(AVLNode t) {
		AVLNode temp = t.left;   //make the rotation
		t.left = temp.right;
		temp.right = t;
		temp.parent = t.parent;  //update parents
		t.parent = temp;
		updateHeight(t);		 //update heights
		updateHeight(temp);
		return temp;
	}
	
	public static AVLNode leftRotate(AVLNode t) {
		AVLNode temp = t.right; //make the rotation
		t.right = temp.left;
		temp.left = t;
		temp.parent = t.parent;	//update parents
		t.parent = temp;
		updateHeight(t);		//update heights
		updateHeight(temp);
		return temp;
	}
	
	public static int getBalance(AVLNode node) {
		return node.leftHeight-node.rightHeight; //returns the balance of the node
												 //helps determine when to re-balance
	}
	
	public static void updateHeight(AVLNode node) { //updates the height of the node
		
		if(node.left != null) 		//the left height
			node.leftHeight = node.left.height;
		else 
			node.leftHeight = -1;
		
		if(node.right != null)		//the right height
			node.rightHeight = node.right.height;
		else
			node.rightHeight = -1;
		
		node.height = max(node.leftHeight, node.rightHeight)+1; //get the height of the node 
		
	}
	
	public static int max(int n, int m) {
		if(n >= m)
			return n;
		else 
			return m;
	}
	
	
	public void printAVL() {
		if(root!= null) {
			printAVL(root);
		}
	}
	private void printAVL(AVLNode bst) { //pre-order traversal of the AVL
		if(bst != null) {
			System.out.print(bst.data);
			printAVL(bst.left);
			printAVL(bst.right);
		}
		
	} 
	
}
