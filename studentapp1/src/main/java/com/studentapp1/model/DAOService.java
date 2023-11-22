package com.studentapp1.model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean verifyLogin(String email, String password);
	public void saveRegistration(String name, String city, String email,String mobile);
	public void deleteRegistration(String email);
	public void updateRegistration(String email, String mobile);
	
	public ResultSet listAllReg();
	
	public void closeDB();

}
