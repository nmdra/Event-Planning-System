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


/*	public static Admin getAdmin(String username, String password) {
		Admin admin = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.connectDB();
			String sql = "SELECT * FROM " + position + " WHERE username = ? AND password = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			if (rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getString(1));
				admin.setName(rs.getString(2));
				admin.setEmail(rs.getString(3));
				admin.setUsername(rs.getString(4));
				admin.setPassword(rs.getString(5));
				admin.setPosition(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return admin;
	}*/

	public static boolean updateAdminProfile(String adminId, String name, String email, String username) {
		boolean isSuccess = false;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.connectDB();
			stmt = conn.createStatement();
			String sql = "UPDATE admin SET name = '" + name + "', email = '" + email + "', username = '" + username + "' WHERE adminid = '" + adminId + "'";
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Close database resources
		}
		return isSuccess;
	}

	public static Admin getAdminDetails(String adminId) {
		Admin admin = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.connectDB();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM admin WHERE adminid = '" + adminId + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getString(1));
				admin.setName(rs.getString(2));
				admin.setEmail(rs.getString(3));
				admin.setUsername(rs.getString(4));
				admin.setPassword(rs.getString(5));
				admin.setPosition(rs.getString(6));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return admin;
	}

	public static boolean deleteAdminAccount(String adminId) {
		boolean isSuccess = false;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBConnection.connectDB();
			stmt = conn.createStatement();
			String sql = "DELETE FROM admin WHERE adminid = '" + adminId + "'";
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return isSuccess;
	}

}
