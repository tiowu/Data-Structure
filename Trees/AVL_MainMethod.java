package uniqueAVL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("/users/nikolabaci/desktop/sorted.txt"); //contains the list of all 24 permutations of [1,2,3,4]
		Scanner userInput = new Scanner(file);
		AVL avl = new AVL();
		
		while(userInput.hasNextLine()) { //while the file has more lines, continue
			
			AVLNode a = new AVLNode(Integer.parseInt(userInput.next())); //read the numbers in the same line
			AVLNode b = new AVLNode(Integer.parseInt(userInput.next()));
			AVLNode c = new AVLNode(Integer.parseInt(userInput.next()));
			AVLNode d = new AVLNode(Integer.parseInt(userInput.next()));

			avl.insert(a); //insert them to the AVL
			avl.insert(b); //if necessary, re-balance the tree 
			avl.insert(c); 
			avl.insert(d); 
		
			avl.printAVL();	//pre-order traversal

			System.out.println();
			avl.delete();	//start new tree
		}	
		userInput.close();
	}
}
