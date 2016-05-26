package beehive.bean;

import java.io.Serializable;

public class User implements Serializable{
	// Member variable
	public String phone;
	public String nickname;
	public String password;
	
	// Construct
	public User() {
		super();
	}
	public User(String phone, String nickname, String password) {
		super();
		this.phone = phone;
		this.nickname = nickname;
		this.password = password;
	}

	// Getters and Setters
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
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
	@Override
    public String toString() {
        return "User [phone=" + phone + ", nickname=" + nickname + "]";
    }
}
