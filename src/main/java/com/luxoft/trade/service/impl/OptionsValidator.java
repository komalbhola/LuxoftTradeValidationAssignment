package com.luxoft.trade.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.luxoft.trade.beans.TradeTransactionRequest;
import com.luxoft.trade.service.TransactionValidator;
import com.luxoft.trade.utils.LuxoftTradeConstants;

public class OptionsValidator extends TransactionValidator {

	public OptionsValidator(TradeTransactionRequest tradeTransactionRequest) {
		super(tradeTransactionRequest);
	}

	@Override
	public void transactionTypeSpecificValidations() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LuxoftTradeConstants.DATE_FORMAT);
		LocalDate exerciseStartDate = null;
	    LocalDate tradeDate = null;
	    LocalDate expiryDate = null;
	    LocalDate premiumDate = null;
	    LocalDate deliveryDate = null;
	    String style= null;
	        
		if(tradeTransactionRequest.getTradeDate() == null || tradeTransactionRequest.getTradeDate().isEmpty()){
			errorList.add(LuxoftTradeConstants.TRADE_DATE_EMPTY_OR_NULL);
		}else{
			tradeDate = LocalDate.parse(tradeTransactionRequest.getTradeDate(), formatter);
		}
		
		if(tradeTransactionRequest.getExcerciseStartDate() == null ||tradeTransactionRequest.getExcerciseStartDate().isEmpty()){
			errorList.add(LuxoftTradeConstants.EXERCISE_START_DATE_EMPTY_OR_NULL);
		}else{
			exerciseStartDate = LocalDate.parse(tradeTransactionRequest.getExcerciseStartDate(), formatter);
		}
		
		if(tradeTransactionRequest.getExpiryDate() == null || tradeTransactionRequest.getExpiryDate().isEmpty()){
			errorList.add(LuxoftTradeConstants.EXPIRY_DATE_EMPTY_OR_NULL);
		}else{
			expiryDate = LocalDate.parse(tradeTransactionRequest.getExpiryDate(), formatter);
		}
		
		if(tradeTransactionRequest.getPremiumDate() == null || tradeTransactionRequest.getPremiumDate().isEmpty() ){
			errorList.add(LuxoftTradeConstants.PREMIUM_DATE_EMPTY_OR_NULL);
		}else{
			premiumDate = LocalDate.parse(tradeTransactionRequest.getPremiumDate(), formatter);
		}
		
		if(tradeTransactionRequest.getDeliveryDate() == null || tradeTransactionRequest.getDeliveryDate().isEmpty()){
			errorList.add(LuxoftTradeConstants.DELIVERY_DATE_EMPTY_OR_NULL);
		}else{
			deliveryDate = LocalDate.parse(tradeTransactionRequest.getDeliveryDate(), formatter);
		}
        
		if(tradeTransactionRequest.getStyle() == null || tradeTransactionRequest.getStyle().isEmpty()){
			errorList.add(LuxoftTradeConstants.STYLE_EMPTY_OR_NULL);
		}else{
			style = tradeTransactionRequest.getStyle();
			if( !(style.equalsIgnoreCase(LuxoftTradeConstants.STYLE_AMERICAN) || 
					style.equalsIgnoreCase(LuxoftTradeConstants.STYLE_EUROPEAN) )){
				errorList.add(LuxoftTradeConstants.INVALID_STYLE);
			}
		}
		
		if(style!=null && tradeDate!=null && exerciseStartDate!=null && expiryDate!=null && deliveryDate!=null && premiumDate!=null){
			
			if(style.equalsIgnoreCase(LuxoftTradeConstants.STYLE_AMERICAN)){
		        if (exerciseStartDate.isBefore(tradeDate)) {
		        	errorList.add(LuxoftTradeConstants.EXERCISE_DATE_BEFORE_TRADE_DATE);
		        } else if (exerciseStartDate.isAfter(expiryDate)) {
		        	errorList.add(LuxoftTradeConstants.EXERCISE_DATE_AFTER_EXPIRY_DATE);
		        } 
			}
			
			if(expiryDate.isAfter(deliveryDate)){
				errorList.add(LuxoftTradeConstants.EXERCISE_DATE_AFTER_DELIVERY_DATE);
			}
			if(premiumDate.isAfter(deliveryDate)){
				errorList.add(LuxoftTradeConstants.PREMIUM_DATE_AFTER_DELIVERY_DATE);
			}
		}
	}
	
}
