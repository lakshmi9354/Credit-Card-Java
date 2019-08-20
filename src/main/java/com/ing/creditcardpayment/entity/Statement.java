package com.ing.creditcardpayment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Statement implements Serializable {
	
	private static final long serialVersionUID = 7771935079393339853L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int statementId;
	private Long creditCardNumber;
	private Double amount;
	private String transactionType;
	private Date transactionDate;
	private String reason;
	private String transactionStatus;
	public int getStatementId() {
		return statementId;
	}
	public void setStatementId(int statementId) {
		this.statementId = statementId;
	}
	public Long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
