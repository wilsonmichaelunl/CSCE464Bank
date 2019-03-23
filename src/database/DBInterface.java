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
	
	public Bank getCreditCardByUserId(int userId) {
		Bank bank = new Bank();
		DBInterface dbInterface = new DBInterface();
		dbInterface.OpenConnection();
		conn = dbInterface.getConnection();
		String query = "SELECT * FROM creditcards WHERE userId = ?";
		
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				  //Retrieve by column name
			    bank.setCreditCardId(rs.getInt("Id"));
			    bank.setCardHolderFirstName(rs.getString("CardHolderFirstName"));
			    bank.setCardHolderLastName(rs.getString("CardHolderLastName"));
			    bank.setCreditCardNumber(rs.getString("CreditCardNumber"));
			    bank.setBalance(rs.getBigDecimal("Balance"));
			    bank.setCardType(rs.getString("CardType"));
			    bank.setCvv(rs.getString("CVV"));
			    bank.setExpirationDate(rs.getString("ExpirationDate"));
			}
			
			dbInterface.CloseQueryConnection(ps, rs);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return bank;
	}
	
	public void updateCreditCardBalance(int id, BigDecimal newBalance) {
		DBInterface dbInterface = new DBInterface();
		dbInterface.OpenConnection();
		conn = dbInterface.getConnection();
		String query = "UPDATE creditcards SET Balance = ? WHERE Id = ?";
		
		try {
			ps = conn.prepareStatement(query);
			ps.setBigDecimal(1, newBalance);
			ps.setInt(2, id);
			ps.executeUpdate();
			ResultSet rs = null;
			
			dbInterface.CloseQueryConnection(ps, rs);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}