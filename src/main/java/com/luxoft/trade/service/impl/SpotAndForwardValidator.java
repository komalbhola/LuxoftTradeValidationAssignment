package com.luxoft.trade.service.impl;

import com.luxoft.trade.beans.TradeTransactionRequest;
import com.luxoft.trade.service.TransactionValidator;
import com.luxoft.trade.utils.LuxoftTradeConstants;

public class SpotAndForwardValidator extends TransactionValidator {

	public SpotAndForwardValidator(TradeTransactionRequest tradeTransactionRequest) {
		super(tradeTransactionRequest);
	}

	@Override
	public void transactionTypeSpecificValidations() {
		
		if(tradeTransactionRequest.getValueDate() == null || tradeTransactionRequest.getValueDate().isEmpty()){
			errorList.add(LuxoftTradeConstants.VALUE_DATE_EMPTY_OR_NULL);
		}
		
	}
}
