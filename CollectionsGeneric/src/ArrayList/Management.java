package ArrayList;

import java.util.ArrayList;
import java.util.Vector;

public class Management {
//	ArrayList<Product> prList;
	Vector<Product> vrListPr;

	public Management() {
		super();
//		prList = new ArrayList<Product>(12);
		vrListPr = new Vector<>(10);
	}
	
	public void addProduct(){
		Product a = new Product();
		a.input();
//		prList.add(a);
		vrListPr.add(a);
	}
	
	public boolean searchByID(String id){
//		for (int i = 0; i < prList.size(); i++) {
//			if(prList.get(i).getId().equalsIgnoreCase(id)){
//				return true;
//			}			
//		}
		
		for(int i=0; i<vrListPr.size();i++){
			if(vrListPr.get(i).getId().equalsIgnoreCase(id)){
				return true;
			}
		}		
		
		return false;
	}
	
	public void displayAll(){
//		for (int i = 0; i < prList.size(); i++) {
//			System.out.print("\n"+(i+1)+". ");
//			//prList.get(i).output();
//			System.out.println(prList.get(i));
//		}
		
		for (int i = 0; i < vrListPr.size(); i++) {
			System.out.print("\n"+(i+1)+". ");
			vrListPr.get(i).output();
		}
	}
	
	public void displayHighValue(){
		int j=1;
//		for (int i = 0; i < prList.size(); i++) {
//			if(prList.get(i).unitPrice >= 500){
//				System.out.print("\n"+j+". ");
//				prList.get(i).output();
//				j++;
//			}
//		}
		
		for (int i = 0; i < vrListPr.size(); i++) {
			if(vrListPr.get(i).unitPrice>=500){
				System.out.print("\n"+j+". ");
				System.out.println(vrListPr.get(i));
				j++;
			}
		}
	}
	
	
	/*
	// Creating arraylist
    ArrayList<String> list = new ArrayList<String>();
    // Add objects to arraylist
    list.add("Java");
    list.add("C++");
    list.add("PHP");
    list.add("Java");
    // Show list through Iterator
    Iterator<String> itr = list.iterator();
    while (itr.hasNext()) {
        System.out.print(itr.next() + ", ");
    }
    // Show list through for-each
    System.out.println();
    for (String obj : list) {
        System.out.print(obj + ", ");
    }
    // Show list through index
    System.out.println();
    int size = list.size();
    for (int i = 0; i < size; i++) {
        System.out.print(list.get(i) + ", ");
    }*/

	
}