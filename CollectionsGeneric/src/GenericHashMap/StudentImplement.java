package GenericHashMap;

import java.util.HashMap;

public class StudentImplement<K,V> {
	
	HashMap<K, V> list;

	public StudentImplement() {
		super();
		list = new HashMap<>();
	}

	public void put(K key, V value) {
		list.put(key, value);
	}
	
	public void displayAll() {
		for (V value : list.values()) {
			System.out.println(value);
		}
	}

}