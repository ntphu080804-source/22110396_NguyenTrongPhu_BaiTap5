package model;

public class User {

	private String fullname;
	private String phone;
	private String avatar; // file name

	public User() {
	}

	public User(String fullname, String phone, String avatar) {
		this.fullname = fullname;
		this.phone = phone;
		this.avatar = avatar;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
