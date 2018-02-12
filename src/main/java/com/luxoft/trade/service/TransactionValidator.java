package com.luxoft.trade.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Set;

import com.luxoft.trade.beans.TradeTransactionRequest;
import com.luxoft.trade.utils.LuxoftTradeConstants;

public abstract class TransactionValidator {

	protected List<String> errorList;
	protected final TradeTransactionRequest tradeTransactionRequest;
	static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LuxoftTradeConstants.DATE_FORMAT);
	
	
	public TransactionValidator(TradeTransactionRequest tradeTransactionRequest) {
		this.tradeTransactionRequest = tradeTransactionRequest;
		this.errorList = new ArrayList<String>();
	}
	
	protected final void commonValidations() throws ParseException {

		LocalDate valueDate = null;
		LocalDate tradeDate = null;
		if(tradeTransactionRequest.getValueDate() == null || tradeTransactionRequest.getValueDate().isEmpty()){
			errorList.add(LuxoftTradeConstants.VALUE_DATE_EMPTY_OR_NULL);
		}else{
			valueDate = LocalDate.parse(tradeTransactionRequest.getValueDate(), formatter);
			
			if (valueDate.getDayOfWeek().getValue() == LuxoftTradeConstants.DAY_SATURDAY 
					|| valueDate.getDayOfWeek().getValue() == LuxoftTradeConstants.DAY_SUNDAY) {
				errorList.add(LuxoftTradeConstants.VALUE_DATE_ON_WEEKEND);
			}
		}
		
		if(tradeTransactionRequest.getTradeDate() == null || tradeTransactionRequest.getTradeDate().isEmpty()) {
			errorList.add(LuxoftTradeConstants.TRADE_DATE_EMPTY_OR_NULL);
		}else{
			tradeDate = LocalDate.parse(tradeTransactionRequest.getTradeDate(), formatter);
		}
		
		if(valueDate!=null && tradeDate!=null){
			if (valueDate.isBefore(tradeDate)) {
				errorList.add(LuxoftTradeConstants.VALUE_DATE_BEFORE_TRADE_DATE);
			}
		}
		

		if(tradeTransactionRequest.getCustomer()==null || tradeTransactionRequest.getCustomer().isEmpty() ){
			errorList.add(LuxoftTradeConstants.CUSTOMER_TYPE_EMPTY_OR_NULL);
		}else{ 
			if (!(tradeTransactionRequest.getCustomer().equalsIgnoreCase(LuxoftTradeConstants.CONSUMER_PLUTO1) 
					|| tradeTransactionRequest.getCustomer().equalsIgnoreCase(LuxoftTradeConstants.CONSUMER_PLUTO2))) {
				errorList.add(LuxoftTradeConstants.VALID_CUSTOMER_TYPES);
			}
		}

		if(tradeTransactionRequest.getLegalEntity()==null || tradeTransactionRequest.getLegalEntity().isEmpty() ){
			errorList.add(LuxoftTradeConstants.LEGAL_ENTITY_EMPTY_OR_NULL);
		}else{ 
			if (!tradeTransactionRequest.getLegalEntity().equalsIgnoreCase(LuxoftTradeConstants.LEGAL_ENTITY)) {
				errorList.add(LuxoftTradeConstants.INVALID_LEGAL_ENTITY);
			}
		}
		
		if(tradeTransactionRequest.getPayCcy()==null || tradeTransactionRequest.getPayCcy().isEmpty()){
			errorList.add(LuxoftTradeConstants.PAY_CURRENCY_EMPTY_OR_NULL);
		}else{ 
			if (!validateCurrencyCodeAsPerISOStandard(tradeTransactionRequest.getPayCcy())) {
				errorList.add(LuxoftTradeConstants.INVALID_PAY_CURRENCY);
			}
		}
		

		if(tradeTransactionRequest.getPremiumCcy()==null || tradeTransactionRequest.getPremiumCcy().isEmpty() ){
			errorList.add(LuxoftTradeConstants.PREMIUM_CURRENCY_EMPTY_OR_NULL);
		}else{ 
			if (!validateCurrencyCodeAsPerISOStandard(tradeTransactionRequest.getPremiumCcy())) {
				errorList.add(LuxoftTradeConstants.INVALID_PREMIUM_CURRENCY);
			}
		}
		
	}

	protected abstract void transactionTypeSpecificValidations();

	public final void validate() throws ParseException {
		commonValidations();
		transactionTypeSpecificValidations();
	}
	
	public final List<String> getErrorList(){
		return this.errorList;
	}
	
	private Boolean validateCurrencyCodeAsPerISOStandard(String currencyCode){
		
		Boolean isValid = false;
		Set<Currency> currencies = Currency.getAvailableCurrencies();
	    isValid = currencies.contains(Currency.getInstance(currencyCode));
	    return isValid;   
	       
	}

}
