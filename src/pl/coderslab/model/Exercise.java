package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sql.DbManager;

public class Exercise {

	private int id;
	private String title;
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", title=" + title + ", description=" + description + "]";
	}

	public Exercise(String title, String description) {
		this.id = 0;
		this.title = title;
		this.description = description;
	}

	public Exercise() {
	}

	public static ArrayList<Exercise> getExerciseFromStatement(PreparedStatement stmt) {
		try {
			ArrayList<Exercise> Exercises = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Exercise myExercise = new Exercise();
				myExercise.id = rs.getInt("id");
				myExercise.title = rs.getString("title");
				myExercise.description = rs.getString("description");
				Exercises.add(myExercise);
			}
			return Exercises;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Exercise loadById(int id) {
		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM Exercise WHERE ID = ?";
			PreparedStatement stmt = conn.prepareStatement(querry);
			stmt.setInt(1, id);
			return getExerciseFromStatement(stmt).get(0);

		} catch (Exception e) {

			return null;
		}
	}

	public static ArrayList<Exercise> loadAllByUserId(int userId) {
		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM Exercise JOIN Solution ON Solution.exercise_id = Exercise.id JOIN Users ON Solution.user_id = Users.id WHERE Users.id = ?";

			PreparedStatement stmt = conn.prepareStatement(querry);
			stmt.setInt(1, userId);
			return getExerciseFromStatement(stmt);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static ArrayList<Exercise> loadAll() {

		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM Exercise";
			PreparedStatement stmt = conn.prepareStatement(querry);
			return getExerciseFromStatement(stmt);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void saveToDB() {
		if (this.id == 0) {
			try (Connection conn = DbManager.getConnection()) {
				String querry = "INSERT	INTO Exercise(title, description) VALUES	(?,	?)";
				String generatedColumns[] = { "ID" };

				PreparedStatement stmt = DbManager.getPreparedStatement(querry, generatedColumns);
				stmt.setString(1, this.title);
				stmt.setString(2, this.description);
				stmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try (Connection conn = DbManager.getConnection()) {
				String querry = "UPDATE Exercise SET title = ?, description = ? WHERE id = ?";
				PreparedStatement stmt = conn.prepareStatement(querry);
				stmt.setString(1, this.title);
				stmt.setString(2, this.description);
				stmt.setInt(3, id);
				stmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void delete() {
		try (Connection conn = DbManager.getConnection()) {
			if (this.id != 0) {
				String querry = "DELETE	FROM Exercise	where	id	=	?";
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
