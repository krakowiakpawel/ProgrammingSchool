package pl.coderslab.model;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// UserLoadAll testUser = new UserLoadAll(3, "Jarosła", "jaroslaw@gmail.com", "pass");

		// testUser.saveToDB();

		// new UserLoadAll(person_group_id, username, email, password)

		// testUser.delete();

		 List<Solution> testList = Solution.loadAll(0);
		 System.out.println(testList);
//		UserLoadAll test = UserLoadAll.loadById(114);
//		System.out.println(test);
//		if (test != null) {
//		System.out.println(test.toString());
//		} else {
//			System.out.println("Pusto, null");
//		}
		
		// test.delete();

		// Test ------------------------UserGropup------------------------
		// --------1------------
		// Group uG = new Group ("php");
		// uG.saveToDB(); -- OK!
		// --------2------------
		// List <Group> uList = Group.loadAllByGroupId(1);
		// System.out.println(uList); // -- OK!
		// --------3------------
		// Group uG = Group.loadById(2);
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
//		 Exercise ex = Exercise.loadById(4);
//		 System.out.println(ex); // -- OK!
		// --------4------------
		// ex.delete();
		// System.out.println("OK");// -- OK!
		// --------5------------
		// List <Exercise> eList = Exercise.loadAllByUserId(2);
		// System.out.println(eList);
	}
}
