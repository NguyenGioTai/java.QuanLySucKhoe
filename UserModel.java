package model;

public class UserModel {
	private String username;
	private String password;

	// Constructor
	public UserModel(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// Getter và Setter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
