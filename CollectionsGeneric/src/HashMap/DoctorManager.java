package HashMap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

public class DoctorManager {
	HashMap<String, Doctor> hashmap;
	Hashtable<String, Doctor> hashtable;
	TreeMap<String, Doctor> treemap;

	public DoctorManager(HashMap<String, Doctor> hashmap, Hashtable<String, Doctor> hashtable,
			TreeMap<String, Doctor> treemap) {
		super();
		this.hashmap = hashmap;
		this.hashtable = hashtable;
		this.treemap = treemap;
	}

	public DoctorManager() {
		super();
		hashmap = new HashMap<>();
		hashtable = new Hashtable<>();
		treemap = new TreeMap<>();
	}

	public void add(String id, Doctor doc) {
		hashmap.put(id, doc);
		hashtable.put(id, doc);
		treemap.put(id, doc);
	}

	public void displayAll() {
		int i = 1;
		for (Doctor value : hashmap.values()) {
			System.out.println(i + ". " + value);
			i++;
		}
		for (Doctor value : hashtable.values()) {
			System.out.println(i + ". " + value);
			i++;
		}
		for (Doctor value : treemap.values()) {
			System.out.println(i + ". " + value);
			i++;
		}
	}

	public void Search(String id) {
		// if(hashmap.containsKey(id)){
		// if (hashtable.containsKey(id)) {
		if (treemap.containsKey(id)) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}
	}
}