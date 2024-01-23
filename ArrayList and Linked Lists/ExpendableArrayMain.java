package day_02_arrays;

public class ExpendableArrayMain {

	public static void main(String[] args) {
		ExpendableArray arr = new ExpendableArray();
		arr.add("Joe");
		arr.add("Tim");
		arr.add("Zoe");
		System.out.print("Size = " + arr.getSize() 
						+ ", Cap = " + arr.getCapacity() + ": ");
		System.out.println(arr.toString());
		
		arr.add("Ari");
		System.out.print("Size = " + arr.getSize() 
						+ ", Cap = " + arr.getCapacity() + ": ");
		System.out.println(arr.toString());
		
		arr.remove(); //Remove Ari
		arr.remove(0); //Remove Joe
		System.out.print("Size = " + arr.getSize() 
		+ ", Cap = " + arr.getCapacity() + ": ");
		System.out.println(arr.toString());
		
		arr.remove();
		System.out.print("Size = " + arr.getSize() 
		+ ", Cap = " + arr.getCapacity() + ": ");
		System.out.println(arr.toString());
		
		
		ExpendableArrayGeneric<Character> arrChar = new ExpendableArrayGeneric<>();
		arrChar.add('j');
		arrChar.add('o');
		arrChar.add('p');
		arrChar.add('p');
		arrChar.insert('8', 4);
		System.out.print("Size = " + arrChar.getSize() 
		+ ", Cap = " + arrChar.getCapacity() + ": ");
		System.out.println(arrChar.toString());
		
	}

}
