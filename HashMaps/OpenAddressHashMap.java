package day_06_hashmaps;

public class OpenAddressHashMap<K,V> {
	final int CAPACITY = 5;
	Pair<K,V>[] bucket;
	int size;
	
	public OpenAddressHashMap() {
		bucket = (Pair<K,V>[]) new Pair[CAPACITY];
		size = 0;		
	}
	
	public void put(Pair pair) {
		
	}
	
	public Pair<K,V> get(){
		return null;
	}
	
	public Pair<K,V> remove(){
		return null;
	}
	
	public LinkedList<K> keySet() {
		return null;
	}
	
	public LinkedList<Pair<K,V>> entrySet(){
		return null;
	}	
}
