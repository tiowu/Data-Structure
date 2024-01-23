package uniqueAVL;

public class AVLNode {
	int data;
	AVLNode parent;
	AVLNode left;
	AVLNode right;
	int leftHeight;
	int rightHeight;
	int height;
	
	AVLNode(){
		data = 0;
		parent = null;
		left = null;
		right = null;
		leftHeight = -1;
		rightHeight = -1;
		height = 0;
	}
	
	AVLNode(int n){
		data = n;
		parent = null;
		left = null;
		right = null;
		leftHeight = -1;
		rightHeight = -1;
		height = 0;
	}
	
	//all getters are used for troubleshooting
	public int getP() {
		if(parent == null)
			return -1;
		return parent.data;
	}
	public int getH() {return height;}		 
	public int getLH() {return leftHeight;}
	public int getRH() {return rightHeight;}
	
	public void setData(int n) { data = n;}
}
