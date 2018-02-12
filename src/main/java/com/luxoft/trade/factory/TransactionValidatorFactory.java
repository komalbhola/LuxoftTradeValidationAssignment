package com.luxoft.trade.factory;

import com.luxoft.trade.beans.TradeTransactionRequest;
import com.luxoft.trade.beans.TransactionType;
import com.luxoft.trade.service.TransactionValidator;
import com.luxoft.trade.service.impl.OptionsValidator;
import com.luxoft.trade.service.impl.SpotAndForwardValidator;

public final class TransactionValidatorFactory {	

	public static TransactionValidator getTransactionValidatorByType(TradeTransactionRequest tradeTransactionRequest) {
		
		String requestTransactionType = tradeTransactionRequest.getType();
		
		if(TransactionType.SPOT.getTransactionTypeValue().equalsIgnoreCase(requestTransactionType) || 
				TransactionType.FORWARD.getTransactionTypeValue().equalsIgnoreCase(requestTransactionType))
			return new SpotAndForwardValidator(tradeTransactionRequest);
		else if(TransactionType.OPTIONS.getTransactionTypeValue().equalsIgnoreCase(requestTransactionType))
			return new OptionsValidator(tradeTransactionRequest);
		else
			throw new UnsupportedOperationException("Operation not supported");
	}

}
