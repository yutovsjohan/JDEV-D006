package TreeMapGeneric;

import java.util.TreeMap;

public class BookManager<K,V> {
	TreeMap<K, V>list;

	public BookManager() {
		super();
		list = new TreeMap<>();
	}
	
	public void addNewBook(K key, V value){
		list.put(key, value);
	}
	
	public void displayAll(){
		for (V value : list.values()) {
			System.out.println(value);
		}
	}
	
	public int Count(){
		return list.size();
	}
}