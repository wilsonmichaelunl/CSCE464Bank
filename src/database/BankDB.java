package database;

import java.math.BigDecimal;

import models.Bank;

public class BankDB {
	public Bank getCreditCardByUserId(int userId) {
		DBInterface dbInterface = new DBInterface();
		Bank creditCard = dbInterface.getCreditCardByUserId(userId);
		
		return creditCard;
	}
	
	public void updateCreditCardBalance(int id, BigDecimal newBalance) {
		DBInterface dbInterface = new DBInterface();
		dbInterface.updateCreditCardBalance(id, newBalance);
	}
}
