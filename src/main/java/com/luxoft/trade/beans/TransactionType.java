package com.luxoft.trade.beans;

public enum TransactionType {

	SPOT("SPOT"),
    OPTIONS("OPTIONS"),
    FORWARD("FORWARD");
    
    private String transactionTypeValue;
    
    TransactionType(String transactionTypeValue){
    	this.transactionTypeValue = transactionTypeValue;
    	
    }

	public String getTransactionTypeValue() {
		return transactionTypeValue;
	}

	public void setTransactionTypeValue(String transactionTypeValue) {
		this.transactionTypeValue = transactionTypeValue;
	}
   
    
}
