package Models;

public class eventplanner {

	private String plannerid ;
	private String name;
	private String email;
	private String username;
	private String password;
	private String position ;

	public eventplanner() {
		this.plannerid = " ";
		this.name = " ";
		this.email = " ";
		this.username = " ";
		this.password =" ";
		this.position = " ";
	}

	public String getPlannerid() {
		return plannerid;
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



	public void setPlanner(String plannerid) {
		this.plannerid = plannerid;
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

