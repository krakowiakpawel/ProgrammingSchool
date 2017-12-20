package myPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

public class User {

	private int id;
	private String username;
	private String email;
	private String password;
	private String salt;
	private int user_group_id;

	public User() {
	}

	public User(int user_group_id, String username, String email, String password) {
		super();
		this.user_group_id = user_group_id;
		this.username = username;
		this.email = email;
		this.setPassword(password);
	}

	@Override
	public String toString() {
		return "id: " + this.id + " username: " + this.username + " email:" + this.email + " password:" + this.password;
	}

	public void setPassword(String password) {
		this.salt = BCrypt.gensalt();
		String hash = BCrypt.hashpw(password, salt);
		this.password = hash;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPerson_group_id() {
		return user_group_id;
	}

	public void setPerson_group_id(int user_group_id) {
		this.user_group_id = user_group_id;
	}

	public int getId() {
		return id;
	}

	public static ArrayList<User> loadAll() {

		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM Users";
			PreparedStatement stmt = conn.prepareStatement(querry);
			return getUsersFromStatement(stmt, querry);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static ArrayList<User> getUsersFromStatement(PreparedStatement stmt, String querry) {
		try {
			ArrayList<User> users = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.id = rs.getInt("id");
				user.email = rs.getString("email");
				user.user_group_id = rs.getInt("user_group_id");
				user.username = rs.getString("username");
				user.password = rs.getString("password");
				users.add(user);
			}
			return users;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<User> loadAllByGroupId(int id) {

		try (Connection conn = DbManager.getConnection()) {

			// Sprawdzić wielkości liter w querry
			String querry = "SELECT * FROM Users  where user_group_id= ?"; // JOIN Group ON
																				// Users.user_group_id=Group.Id
			PreparedStatement stmt = conn.prepareStatement(querry);
			stmt.setInt(1, id);
			return getUsersFromStatement(stmt, querry);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static User loadById(int id) {
		try (Connection conn = DbManager.getConnection()) {
			String querry = "SELECT * FROM Users WHERE ID = ?";
			PreparedStatement stmt = conn.prepareStatement(querry);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User loadedUser = new User();
				loadedUser.id = rs.getInt("id");
				loadedUser.email = rs.getString("email");
				loadedUser.user_group_id = rs.getInt("user_group_id");
				loadedUser.username = rs.getString("username");
				loadedUser.password = rs.getString("password");
				loadedUser.salt = rs.getString("salt");
				return loadedUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveToDB() {
		if (this.id == 0) {
			try (Connection conn = DbManager.getConnection()) {
				String querry = "INSERT	INTO Users(username,email,password,salt,user_group_id) VALUES	(?,	?, ?, ?, ?)";
				String generatedColumns[] = { "ID" };

				PreparedStatement stmt = DbManager.getPreparedStatement(querry, generatedColumns);
				stmt.setString(1, this.username);
				stmt.setString(2, this.email);
				stmt.setString(3, this.password);
				stmt.setString(4, this.salt);
				stmt.setInt(5, this.user_group_id);
				stmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void delete() {
		try (Connection conn = DbManager.getConnection()) {
			if (this.id != 0) {
				String querry = "DELETE	FROM Users	where	id	=	?";
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
