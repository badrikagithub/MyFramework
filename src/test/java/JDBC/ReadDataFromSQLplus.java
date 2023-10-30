package JDBC;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromSQLplus {

	public static void main(String[] args) throws SQLException 
	{
		
		//Register or load the SQL DB. Get driver from mysql jar and register this in manager
		Driver driverRef=new Driver();
		
		
		//STEP-1 Register the DB
		DriverManager.registerDriver(driverRef);
		//step-2 get the conncetion with DB
		
		// STEP-3 iSSUE THE CREATE Statement
		//Step-4 execute a query
	//	step -5 close the DB
		
		
	}

}
