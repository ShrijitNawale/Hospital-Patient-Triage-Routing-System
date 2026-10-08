package com.kiranacademy.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String DriverName="com.mysql.cj.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost:3306/Hosptial_Management";
	private static final String UserName= "root";
	private static final String Password="root";
    public static Connection getConnection(){
    	
        try {
            Class.forName(DriverName);
            return DriverManager.getConnection(Url,UserName,Password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            System.out.println(e);
        }
        return null;
    }

	
}