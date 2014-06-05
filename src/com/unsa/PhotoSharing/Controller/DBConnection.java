package com.unsa.PhotoSharing.Controller;
import java.sql.*;

public class DBConnection
{
	public static DBConnection instance = null;
	
	private Connection connection;
	public Connection getConnection()
	{
		return connection;
	}
	
	public static DBConnection getInstance()
	{
		if(instance == null)
			return new DBConnection();
		else return instance;
	}

	public DBConnection()
	{
		String url = "jdbc:mysql://localhost:3306/photosharing";
		String id = "root";
		String pass = "C3ntralfox";
		connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, id, pass);

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
