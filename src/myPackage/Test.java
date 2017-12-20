package myPackage;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User testUser = new User(3, "Jarosła", "jaroslaw@gmail.com", "pass");
		testUser.saveToDB();

		// new User(person_group_id, username, email, password)

		// testUser.delete();

		// List<User> testList = User.loadAllByGroupId(1);
		// User test = User.loadById(1);
		// System.out.println(test.toString());
		// test.delete();

	}

}
