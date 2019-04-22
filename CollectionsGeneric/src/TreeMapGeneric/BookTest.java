package TreeMapGeneric;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		BookManager<String, Book> a = new BookManager<>();
		Scanner sc;
		int sel;

		while (true) {
			try {
				System.out.println("1. Add new book");
				System.out.println("2. Display book");
				System.out.println("3. Count book");
				System.out.println("4. Exit");
				System.out.print("Your selection: ");
				sc = new Scanner(System.in);
				sel = sc.nextInt();

				if (sel == 1) {
					Book s = new Book();
					s.input();
					a.addNewBook(s.bookID, s);
				} else if (sel == 2) {
					if (a.list.size() == 0) {
						System.out.println("List is empty");
					} else {
						a.displayAll();
					}
				} else if (sel == 3) {
					System.out.println("Have " + a.Count() + " book in list");
				} else if (sel == 4) {
					System.out.println("Shut down.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Your selection is invalid");
			}

		}
	}

}