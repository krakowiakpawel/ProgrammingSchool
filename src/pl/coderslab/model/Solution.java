package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import sql.DbManager;

public class Solution {
	int id;
	private Timestamp created;
	private Timestamp updated;
	private String description;
	private int exercise_id;
	private int user_id;

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public int getexercise_id() {
		return exercise_id;
	}

	public void setexercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUsers_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Solution [id=" + id + ", created=" + created + ", updated=" + updated + ", description=" + description
				+ ", exercise_id=" + exercise_id + ", user_id=" + user_id + "]";
	}

	public Solution(String description, int exercise_id, int user_id) {

		this.description = description;
		this.exercise_id = exercise_id;
		this.user_id = user_id;
	}

	public Solution() {
	}

	public void saveToDB() {
		if (this.id == 0) {
			try (Connection conn = DbManager.getConnection()) {
				String querry = "INSERT	INTO Solution (created,description, exercise_id, user_id) VALUES (NOW(),?,?,?)";
				String generatedColumns[] = { "ID" };

				PreparedStatement stmt = DbManager.getPreparedStatement(querry, generatedColumns);
				stmt.setString(1, description);
				stmt.setInt(2, exercise_id);
				stmt.setInt(3, user_id);
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					this.id = rs.getInt(1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try (Connection conn = DbManager.getConnection()) {
				String querry = "UPDATE Solution SET updated = NOW(),description = ?,exercise_id=?, user_id=? WHERE id = ?";
				PreparedStatement stmt = conn.prepareStatement(querry);
				stmt.setString(1, description);
				stmt.setInt(2, exercise_id);
				stmt.setInt(3, user_id);

				stmt.setInt(4, id);
				stmt.executeUpdate();

			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}

	}

	public void delete() {
		try (Connection conn = DbManager.getConnection()) {
			if (this.id != 0) {
				String querry = "DELETE	FROM Solution	where	id	=	?";
				PreparedStatement stmt = conn.prepareStatement(querry);
				stmt.setInt(1, this.id);
				stmt.executeUpdate();
				this.id = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Solution> loadAllByExerciseId(int exId) {
		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM Solution WHERE exercise_id = ?";
			PreparedStatement stmt = conn.prepareStatement(querry);
			stmt.setInt(1, exId);
			return getSolutionsFromStatement(stmt);

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Solution> loadAllByUserId(int exId) {
		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM Solution WHERE user_id = ?";
			PreparedStatement stmt = conn.prepareStatement(querry);
			stmt.setInt(1, exId);
			return getSolutionsFromStatement(stmt);

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Solution loadByExerciseIdAndSUserId(int exId, int uId) {
		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM Solution WHERE (exercise_id = ? AND user_id = ?)";
			PreparedStatement stmt = conn.prepareStatement(querry);
			stmt.setInt(1, exId);
			stmt.setInt(2, uId);
			return getSolutionsFromStatement(stmt).get(0);

		} catch (

		Exception e) {

			return null;
		}

	}

	public static ArrayList<Solution> getSolutionsFromStatement(PreparedStatement stmt) {
		try {
			ArrayList<Solution> Solutions = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Solution mySolution = new Solution();

				mySolution.id = rs.getInt("id");
				mySolution.created = rs.getTimestamp("created");
				mySolution.updated = rs.getTimestamp("updated");
				mySolution.description = rs.getString("description");
				mySolution.exercise_id = rs.getInt("exercise_id");
				mySolution.user_id = rs.getInt("user_id");
				Solutions.add(mySolution);
			}
			return Solutions;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<Solution> loadAll() {

		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM Solution";
			PreparedStatement stmt = conn.prepareStatement(querry);
			return getSolutionsFromStatement(stmt);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<Solution> loadAll(int limit) {

		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM Solution LIMIT " + limit;
			PreparedStatement stmt = conn.prepareStatement(querry);
			return getSolutionsFromStatement(stmt);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Solution loadSolutionById(int id) {
		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM Solution WHERE ID = ?";
			PreparedStatement stmt = conn.prepareStatement(querry);
			stmt.setInt(1, id);
			return getSolutionsFromStatement(stmt).get(0);

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
