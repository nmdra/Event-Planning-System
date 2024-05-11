package Models.Staff;

public class Admin {

	public Admin(String adminid, String name, String email, String username, String password, String position) {
		this.adminid = adminid;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.position = position;
	}

	private String adminid ;
	private String name;
	private String email;
	private String username;
	private String password;
	private String position ;

	public Admin() {
		this.adminid = " ";
		this.name = " ";
		this.email = " ";
		this.username = " ";
		this.password = " ";
		this.position = " ";
	}

	public String getAdminId() {
		return adminid;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPosition() {
		return position;
	}

	public void setAdminId(String adminid) {
		this.adminid = adminid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
