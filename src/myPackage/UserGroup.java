package myPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserGroup {

	private int id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public UserGroup(String name) {
		this.id = 0;
		this.name = name;
	}

	public UserGroup() {
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: " + this.id + " name: " + name;

	}

	public static ArrayList<UserGroup> getUserGroupsFromStatement(PreparedStatement stmt, String querry) {
		try {
			ArrayList<UserGroup> userGroups = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				UserGroup myUserGroup = new UserGroup();

				myUserGroup.id = rs.getInt("id");
				myUserGroup.name = rs.getString("name");
				userGroups.add(myUserGroup);
			}
			return userGroups;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<UserGroup> loadAll() {

		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM User_group";
			PreparedStatement stmt = conn.prepareStatement(querry);
			return getUserGroupsFromStatement(stmt, querry);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

//	public static ArrayList<UserGroup> loadAllByGroupId(int id) {
//
//		try (Connection conn = DbManager.getConnection()) {
//
//			// Sprawdzić wielkości liter w querry
//			String querry = "SELECT * FROM User_group  where user_group_id= ?"; // JOIN Group ON
//			// Users.user_group_id=Group.Id
//			PreparedStatement stmt = conn.prepareStatement(querry);
//			stmt.setInt(1, id);
//			return getUserGroupsFromStatement(stmt, querry);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//
//	}

	public static UserGroup loadById(int id) {
		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM User_group WHERE ID = ?";
			PreparedStatement stmt = conn.prepareStatement(querry);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				UserGroup myUserGroup = new UserGroup();

				myUserGroup.id = rs.getInt("id");
				myUserGroup.name = rs.getString("name");
				return myUserGroup;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveToDB() {
		if (this.id == 0) {
			try (Connection conn = DbManager.getConnection()) {
				String querry = "INSERT	INTO User_group (name) VALUES	( ? )";
				String generatedColumns[] = { "ID" };

				PreparedStatement stmt = DbManager.getPreparedStatement(querry, generatedColumns);
				stmt.setString(1, this.name);
				stmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void delete() {
		try (Connection conn = DbManager.getConnection()) {
			if (this.id != 0) {
				String querry = "DELETE	FROM User_group	where	id	=	?";
				PreparedStatement stmt = conn.prepareStatement(querry);
				stmt.setInt(1, this.id);
				stmt.executeUpdate();
				this.id = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
