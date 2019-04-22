package BookManagement;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Connection cn = new MyConnect().getcn();
		if(cn==null){
			System.out.println("Not connect");
		}
		else{
			Account a = new Account();
			if(a.login()==1){
				Scanner sc;
				int select;
				while(true){
					try {
						sc=new Scanner(System.in);
						System.out.println("1. Category Management");
						System.out.println("2. Book Management");
						System.out.println("3. Exit");
						System.out.print("Your selection: ");
						select=sc.nextInt();
						
						if(select == 1){
							menuCategory();
						}
						
						else if(select==2){
							menuBook();
						}
						
						else if(select == 3){
							System.out.println("Log out");
							break;
						}
						
						else {
							System.out.println("Your selection is not available");
						}
						
					} catch (InputMismatchException e) {
						System.out.println("Invalid amount");
					}
					
				}
			}
			else if(a.login()!=-1){
				System.out.println("Login success");
			}
		}
	}
	
	public static void menuCategory(){
		Scanner sc;
		int select;
		Category a = new Category();
		while(true){
			try {
				sc=new Scanner(System.in);
				System.out.println("1. Display all categories");
				System.out.println("2. Display all books in a category");
				System.out.println("3. Add new category");
				System.out.println("4. Delete a category");
				System.out.println("5. Update a category");
				System.out.println("6. Exit");
				System.out.print("Your selection: ");
				select=sc.nextInt();
				
				switch(select){
				case 1:
					a.display();
					break;
				case 2:
					a.displayBook();
					break;
				case 3:
					a.add();
					break;
				case 4:
					a.delete();
					break;
				case 5:
					a.update();
					break;
				case 6:
					break;
				default: 
					System.out.println("Your selection is not available");
					break;
				}
				
				if(select==6){
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}
			
		}
	}
	
	
	public static void menuBook(){
		Scanner sc;
		int select;
		Book b = new Book();
		while(true){
			try {
				sc=new Scanner(System.in);
				System.out.println("1. Display all books");
				System.out.println("2. Display all books by category");
				System.out.println("3. Add new book");
				System.out.println("4. Delete a book");
				System.out.println("5. Update a book");
				System.out.println("6. Exit");
				System.out.print("Your selection: ");
				select=sc.nextInt();
				
				switch(select){
				case 1:
					b.display();
					break;
				case 2:
					b.displayByCategory();
					break;
				case 3:
					b.add();
					break;
				case 4:
					b.delete();
					break;
				case 5:
					b.update();
					break;
				case 6:
					break;
				default: 
					System.out.println("Your selection is not available");
					break;
				}
				
				if(select==6){
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}
			
		}
	}
	

}