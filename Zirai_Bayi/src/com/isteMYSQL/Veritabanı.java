package com.isteMYSQL;
import java.sql.*;


public class Veritabanı {

	static Connection conn=null;
	
	public static Connection Baglan() {
		try {
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost/ziraatbayi","root","mysql");
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
