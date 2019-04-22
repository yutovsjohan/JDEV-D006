package GenericHashMap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		StudentImplement<String, Student> a = new StudentImplement<>();
		Scanner sc;
		int sel;

		while (true) {
			try {
				System.out.println("1. Add new student");
				System.out.println("2. Display student");
				System.out.println("3. Exit");
				System.out.print("Your selection: ");
				sc = new Scanner(System.in);
				sel = sc.nextInt();

				if (sel == 1) {
					Student s = new Student();
					s.input();
					a.put(s.stuID, s);
				} else if (sel == 2) {
					if (a.list.size() == 0) {
						System.out.println("List is empty");
					} else {
						a.displayAll();
						System.out.println("Have " + a.list.size() + " students");
					}
				} else if (sel == 3) {
					System.out.println("Shut down.");
					break;
				} else {
					System.out.println("Your selection is available");
				}
			} catch (InputMismatchException e) {
				System.out.println("Your selection is invalid");
			}

		}
	}

}