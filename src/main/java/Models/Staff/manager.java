package Models.Staff;

public class manager {
	
	private String managerid ;
	private String name;
	private String bday;
	private String address;
    private String phonenumber ;
	private String email;
	private String position ;
	private String username;
	private String password;
	
	
	public manager() {
		
		this.managerid = " ";
		this.name = " ";
		this.bday = " " ;
		this.address = " ";
		this.phonenumber = " ";
		this.email = " ";
		this.position = " ";
		this.username = " ";
		this.password = " ";
	}


	public String getManagerid() {
		return managerid;
	}


	public String getName() {
		return name;
	}


	public String getBday() {
		return bday;
	}


	public String getAddress() {
		return address;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public String getEmail() {
		return email;
	}


	public String getPosition() {
		return position;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setBday(String bday) {
		this.bday = bday;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	

}
