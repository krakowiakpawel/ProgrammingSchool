package myPackage;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// User testUser = new User(3, "Jarosła", "jaroslaw@gmail.com", "pass");

		// testUser.saveToDB();

		// new User(person_group_id, username, email, password)

		// testUser.delete();

		 List<User> testList = User.loadAllByGroupId(1);
		 System.out.println(testList);
		// User test = User.loadById(1);
		// System.out.println(test.toString());
		// test.delete();

		// Test ------------------------UserGropup------------------------
		// --------1------------
		// UserGroup uG = new UserGroup ("php");
		// uG.saveToDB(); -- OK!
		// --------2------------
		// List <UserGroup> uList = UserGroup.loadAllByGroupId(1);
		// System.out.println(uList); // -- OK!
		// --------3------------
		// UserGroup uG = UserGroup.loadById(2);
		// System.out.println(uG); //-- OK!
		// --------4------------
		// uG.delete();
		// System.out.println("OK");//-- OK!

		// Test ------------------------Exercise------------------------
		// --------1------------
		// Exercise ex = new Exercise("Task5.5552", "Learn SQLGGGG");
		// ex.saveToDB(); //-- OK!
		// --------2------------
		// List <Exercise> eList = Exercise.loadAll();
		// System.out.println(eList); //-- OK!
		// --------3------------
		// Exercise ex = Exercise.loadById(4);
		// System.out.println(ex); // -- OK!
		// --------4------------
		// ex.delete();
		// System.out.println("OK");// -- OK!
		// --------5------------
//		List <Exercise> eList = Exercise.loadAllByUserId(2);
//		System.out.println(eList);
	}
}
