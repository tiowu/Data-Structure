package day_06_hashmaps;

public class Main {

	public static void main(String[] args) {
		ChainHashMap<String, Integer> map = new ChainHashMap<>();
		
		map.put(new Pair<String, Integer>("A", 0));
		map.put(new Pair<String, Integer>("B", 1));
		map.put(new Pair<String, Integer>("C", 2));
		map.put(new Pair<String, Integer>("D", 3));
		map.put(new Pair<String, Integer>("E", 4));
		map.put(new Pair<String, Integer>("F", 5));
		map.put(new Pair<String, Integer>("R", 6));
		map.put(new Pair<String, Integer>("A", 7));
		
		System.out.println(map);
		
		System.out.println(map.get("A"));
		System.out.println(map.get("X"));
		System.out.println(map.keySet());
		
		LinkedList<String> keyset = map.keySet();
		Node<String> curr = keyset.getFirst();
		
		while(curr != null) {
			String name = curr.data;
			int quizScore = 3 + map.get(name).getValue();
			
			map.put(new Pair<String, Integer>(name, quizScore));
			curr = curr.next;
		}
		
		System.out.println(map);
		
	}
}

