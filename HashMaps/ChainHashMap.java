package day_06_hashmaps;

public class ChainHashMap<K,V> {
	final int CAPACITY = 5;
	LinkedList<Pair<K,V>>[] bucket;
	int size;
	
	public ChainHashMap() {
		bucket = (LinkedList<Pair<K,V>>[]) new LinkedList[CAPACITY];
		for(int i = 0; i < CAPACITY; i++) {
			bucket[i] = new LinkedList<Pair<K,V>>();
		}
		size = 0;		
	}
	
	public void put(Pair<K,V> pair) {
		
		int address = pair.getKey().hashCode() % CAPACITY;
		
		Node<Pair<K,V>> curr = bucket[address].getFirst();
		while(curr != null) {
			if(curr.data.getKey() == pair.getKey()) {
				curr.data.setValue(pair.getValue());
				return;
			}
			curr = curr.next;
		}
		bucket[address].insertLast(pair);
		
		
//		while(curr != null && curr.data.getKey() != pair.getKey()) {
//			curr = curr.next;
//		}
//		if(curr != null) curr.data.setValue(pair.getValue());
//		else bucket[address].insertLast(pair);
	}
	
	public Pair<K,V> get(K key){
		int address = key.hashCode() % CAPACITY;
		Node<Pair<K,V>> curr = bucket[address].getFirst();
		while(curr != null) {
			if(curr.data.getKey() == key) {
				return curr.data;
			}
			curr = curr.next;
		}
		return null;
	}
	
	public Pair<K,V> remove(){
		return null;
	}
	
	public LinkedList<K> keySet() {
		LinkedList<K> ans = new LinkedList<>();
		
		for(int i = 0; i < CAPACITY; i++) {
			Node<Pair<K,V>> curr = bucket[i].getFirst();
			while(curr != null) {
				ans.insertLast(curr.data.getKey());
				curr = curr.next;
			}
		}
		
		return ans;
	}
	
	public LinkedList<Pair<K,V>> entrySet(){
		return null;
	}
	
	public String toString() {
		String ans = "";
		for(int i = 0; i < CAPACITY; i++) {
			
			Node<Pair<K,V>> curr = bucket[i].getFirst();
			ans = ans + i + "|";
			while(curr != null) {
				ans = ans + " -> (" + curr.data.getKey() + ", " +
								curr.data.getValue() + ")";
				curr = curr.next;
			}
			ans += "\n";
		}
		
		return ans;
	}
}
