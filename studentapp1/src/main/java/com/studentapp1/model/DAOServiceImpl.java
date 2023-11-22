package com.studentapp1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
	private Connection con;
	private Statement stmt;

	@Override
	public boolean verifyLogin(String email, String password) {
		try {

			ResultSet result = stmt
					.executeQuery("select * from login where email='" + email + "' and password='" + password + "'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
			stmt.executeUpdate(
					"insert into registration values('" + name + "','" + city + "','" + email + "','" + mobile + "')");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void deleteRegistration(String email) {
		try {

		stmt.executeUpdate("delete from registration where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateRegistration(String email, String mobile) {
		try {

			stmt.executeUpdate("UPDATE registration SET mobile='"+mobile+"' WHERE email='"+email+"' ");
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp1", "root", "admin");
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void closeDB() {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSet listAllReg() {
		try {

			ResultSet result = stmt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
