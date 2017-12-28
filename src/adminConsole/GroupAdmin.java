package adminConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.coderslab.model.Group;

public class GroupAdmin {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("Moduł Group!");
		while (true) {
			System.out.println("[Group] Wybierz funkcję: add, edit, delete lub back:");
			String input = scan.nextLine();
			if (input.equals("add")) {
				addGroup();
			} else if (input.equals("edit")) {
				editGroup();
			} else if (input.equals("delete")) {
				deleteGroup();
			} else if (input.equals("back")) {
				if (Application.areYouSure(scan)) {
					break;
				}
			} else {
				System.out.println("Błąd wyboru");
			}
		}
	}

	private static void deleteGroup() {
		Scanner scan = new Scanner(System.in);
		printGroups();
		System.out.println("Podaj id Group do kasacji:");
		int id = getId(scan);

		Group.loadById(id).delete();
		System.out.println("Deleted!");
	}

	private static void editGroup() {
		Scanner scan = new Scanner(System.in);
		printGroups();

		System.out.println("Podaj id Group do edycji:");
		int id = getId(scan);

		Group temp = createGroup();
		temp.setId(id);

		System.out.println(temp.toString());

		temp.saveToDB();
		System.out.println("Zmieniono dane!");

	}

	private static void addGroup() {
		createGroup().saveToDB();
		System.out.println("Dodano!");

	}

	private static Group createGroup() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Podaj nazwę Grupy:");
		String Groupname = scan.nextLine();

		Group newGroup = new Group(Groupname);
		return newGroup;
	}

	static int getId(Scanner scan) {
		int id = 0;
		List<Group> uList = Group.loadAll();
		List<Integer> idList = new ArrayList<>();
		for (Group Group : uList) {
			int uId = Group.getId();
			idList.add(uId);
		}
		while (true) {

			while (!scan.hasNextInt()) {
				System.out.println("That's not a number!");
				scan.next(); // this is important!
			}
			id = scan.nextInt();
			if (!idList.contains(id)) {
				System.out.println("Wybrany numer nie istenieje");
			} else {
				return id;
			}
		}
	}

	static void printGroups() {
		System.out.println("Lista dostępnych");
		List<Group> GroupList = Group.loadAll();
		for (Group Group : GroupList) {
			System.out.println(Group);
		}
	}

}
