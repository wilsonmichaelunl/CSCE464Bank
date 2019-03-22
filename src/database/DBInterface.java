package database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.*;

public class DBInterface {
	private Connection conn = null;
	private PreparedStatement ps = null;
	
	public void OpenConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
		conn = null;
		try {
			conn = DriverManager.getConnection(DBInfo.url, DBInfo.username, DBInfo.password);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}
	
	public void CloseUpdateConnection(PreparedStatement ps){
		try {
			if(ps != null && !ps.isClosed())
				ps.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}
	
	public void CloseQueryConnection(PreparedStatement ps, ResultSet rs){
		try {
			if(rs != null && !rs.isClosed())
				rs.close();
			if(ps != null && !ps.isClosed())
				ps.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConnection(){
		return conn;
	}
	
}