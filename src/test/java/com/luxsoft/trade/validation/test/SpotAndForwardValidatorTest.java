package com.luxsoft.trade.validation.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luxoft.trade.beans.TradeTransactionRequest;
import com.luxoft.trade.factory.TransactionValidatorFactory;
import com.luxoft.trade.service.TransactionValidator;


@RunWith(SpringJUnit4ClassRunner.class)
public class SpotAndForwardValidatorTest {

	TradeTransactionRequest tradeTransactionRequest = null;

	@Before
	public void setInitialData(){
		
		tradeTransactionRequest = new TradeTransactionRequest();
		tradeTransactionRequest.setType("OPTIONS");
		tradeTransactionRequest.setStyle("American");
		tradeTransactionRequest.setExcerciseStartDate("2016-08-15");
		tradeTransactionRequest.setValueDate("2016-08-22");
		tradeTransactionRequest.setExpiryDate("2016-08-19");
		tradeTransactionRequest.setPremiumDate("2016-08-12");
		tradeTransactionRequest.setDeliveryDate("2016-08-22");
		tradeTransactionRequest.setTradeDate("2016-08-11");
		tradeTransactionRequest.setCustomer("PLUTO1");
		tradeTransactionRequest.setCcyPair("EURUSD");
		tradeTransactionRequest.setDirection("BUY");
		tradeTransactionRequest.setStratergy("CAL");
		tradeTransactionRequest.setAmount1("10000");
		tradeTransactionRequest.setAmount2("20000");
		tradeTransactionRequest.setRate("1.12");
		tradeTransactionRequest.setPayCcy("USD");
		tradeTransactionRequest.setPremium("0.2");
		tradeTransactionRequest.setPremiumCcy("USD");
		tradeTransactionRequest.setPremiumType("USD");
		tradeTransactionRequest.setLegalEntity("CS Zurich");
	}
	
	
	@Test
	public final void spotAndForwardTestSuccess() throws Exception {
		
		TransactionValidator transactionValidator = TransactionValidatorFactory.getTransactionValidatorByType(tradeTransactionRequest);
    	transactionValidator.validate();
    	Assert.assertTrue(transactionValidator.getErrorList().isEmpty());
		
	}
	
}
