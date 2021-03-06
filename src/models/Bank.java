package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

public class Bank {
	private int creditCardId;
	private String cardHolderFirstName;
	private String cardHolderLastName;
	private String creditCardNumber;
	private BigDecimal balance;
	private String cardType;
	private String cvv;
	private String expirationDate;
	
	public Bank() {
		super();
	}

	public int getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}


	public String getCardHolderFirstName() {
		return cardHolderFirstName;
	}

	public void setCardHolderFirstName(String cardHolderFirstName) {
		this.cardHolderFirstName = cardHolderFirstName;
	}

	public String getCardHolderLastName() {
		return cardHolderLastName;
	}

	public void setCardHolderLastName(String cardHolderLastName) {
		this.cardHolderLastName = cardHolderLastName;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int validateBalance(Bank creditCard, BigDecimal totalCost) {
		if(!(creditCard.getBalance().compareTo(totalCost) < 0) ) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int validateDetails(Bank creditCard, String lastName, String firstName, String cardType, String cardNumber, String cvv, String expirationDate) {
		if(creditCard.getCardHolderFirstName().equalsIgnoreCase(firstName) &&
		   creditCard.getCardHolderLastName().equalsIgnoreCase(lastName) &&
		   creditCard.getCardType().equalsIgnoreCase(cardType) &&
		   creditCard.getCreditCardNumber().equalsIgnoreCase(cardNumber) &&
		   creditCard.getCvv().equalsIgnoreCase(cvv) &&
		   creditCard.getExpirationDate().equalsIgnoreCase(expirationDate)) {
			return 1;
		}else {
			return 0;
		}
	}
}
