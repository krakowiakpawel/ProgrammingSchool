package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sql.DbManager;

public class Group {

	private int id;
	private String name;
	private int number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Group(String name) {
		this.id = 0;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Group() {
	}

	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: " + this.id + " name: " + name;

	}

	public static ArrayList<Group> getUserGroupsFromStatement(PreparedStatement stmt) {
		try {
			ArrayList<Group> userGroups = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Group myUserGroup = new Group();

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

	public static ArrayList<Group> loadAll() {

		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM User_group";
			PreparedStatement stmt = conn.prepareStatement(querry);
			return getUserGroupsFromStatement(stmt);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// public static ArrayList<Group> loadAllByGroupId(int id) {
	//
	// try (Connection conn = DbManager.getConnection()) {
	//
	// // Sprawdzić wielkości liter w querry
	// String querry = "SELECT * FROM User_group where user_group_id= ?"; // JOIN
	// Group ON
	// // Users.user_group_id=Group.Id
	// PreparedStatement stmt = conn.prepareStatement(querry);
	// stmt.setInt(1, id);
	// return getUserGroupsFromStatement(stmt, querry);
	// } catch (Exception e) {
	// e.printStackTrace();
	// return null;
	// }
	//
	// }

	public static Group loadById(int id) {
		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM User_group WHERE ID = ?";
			PreparedStatement stmt = conn.prepareStatement(querry);
			stmt.setInt(1, id);
			return getUserGroupsFromStatement(stmt).get(0);

		} catch (Exception e) {
			return null;
		}
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
		} else {
			try (Connection conn = DbManager.getConnection()) {
				String querry = "UPDATE User_group SET name = ? WHERE id = ?";
				PreparedStatement stmt = conn.prepareStatement(querry);
				stmt.setString(1, this.name);
				stmt.setInt(2, id);
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
