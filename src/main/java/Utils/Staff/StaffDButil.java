package Utils.Staff;

import Models.Staff.Admin;
import Models.Staff.eventplanner;
import Utils.DBConnection;

import java.sql.*;

public class StaffDButil {
	private static boolean isSuccess;
	private static Connection con = null ;
	private static Statement stat = null;
	private static ResultSet rs = null ;

	//validate user
	public static boolean validatelogin (String username, String password, String position) {

		try {

			con = DBConnection.connectDB();
			stat = con.createStatement();

			String sql = "select * FROM " + position + " where username ='"+username+"' and password = '"+password+"'"; //sql query
			rs = stat.executeQuery(sql);

            isSuccess = rs.next();

		}catch(Exception e) {

			e.printStackTrace();
		}


		return isSuccess ;
	}

	public static eventplanner geteventplanner(String username, String password, String position){

		eventplanner eventplanner1 = null;

		try {

			con = DBConnection.connectDB();
			stat = con.createStatement();

			String sql = "select * FROM " + position + " where username ='"+username+"' and password = '"+password+"'"; //sql query

			rs = stat.executeQuery(sql);  // run sql query

			while(rs.next()) {

				eventplanner1 = new eventplanner();

				eventplanner1.setPlanner(rs.getString(1));
				eventplanner1.setName( rs.getString(2));
				eventplanner1.setEmail( rs.getString(3));
				eventplanner1.setUsername( rs.getString(4));
				eventplanner1.setPassword( rs.getString(5));
				eventplanner1.setPosition(rs.getString(6));

			}

		}catch (Exception e){

			e.printStackTrace();

		}

		return eventplanner1 ;
	}

	//update profile details
	public static boolean updateplannerprofile(String plannerid, String name ,String email, String username ) {

		try {

			con = DBConnection.connectDB();
			stat = con.createStatement();

			String sql = "update  eventplanner set name = '"+name+"', email = '"+email+"', username = '"+username+"' where plannerid = '"+plannerid+"' ";
			int rs = stat.executeUpdate(sql);

            isSuccess = rs > 0;

		}catch(Exception e) {
			e.printStackTrace();
		}

		return isSuccess ;
	}


	public static eventplanner getplannerDeatials(String plannerId ){

		eventplanner eventplanner1 = null;
		//validate
		try {
			con = DBConnection.connectDB();
			stat = con.createStatement();

			String sql = "select * FROM eventplanner where plannerid = '"+plannerId+"'"; //sql query

			rs = stat.executeQuery(sql);  // run sql query

			while(rs.next()) {

				eventplanner1 = new eventplanner();
				eventplanner1.setPlanner(rs.getString(1));
                eventplanner1.setName( rs.getString(2));
				eventplanner1.setEmail( rs.getString(3));
				eventplanner1.setUsername( rs.getString(4));
				eventplanner1.setPassword( rs.getString(5));
				eventplanner1.setPosition(rs.getString(6));
			}

		}catch (Exception e){
			e.printStackTrace();
		}

		return eventplanner1 ;
	}

	//delete manageraccount
	public static boolean deletplanneraccount(String plannerid) {

		try {
			con = DBConnection.connectDB();
			stat = con.createStatement();

			String sql = "delete from eventplanner where plannerid = '"+plannerid+"' ";
			int rs = stat.executeUpdate(sql);

            isSuccess = rs > 0;

		}catch(Exception e) {

			e.printStackTrace();
		}

		return isSuccess;
	}

}
