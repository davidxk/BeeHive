package beehive.bean;

public class User {
	// Member variable
	public int phone;
	public String nickname;
	public String password;
	
	// Construct
	public User() {
		super();
	}
	public User(int phone, String nickname, String password) {
		super();
		this.phone = phone;
		this.nickname = nickname;
		this.password = password;
	}

	// Getters and Setters
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
