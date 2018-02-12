package com.luxoft.trade.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luxoft.trade.beans.TradeTransactionRequest;
import com.luxoft.trade.factory.TransactionValidatorFactory;
import com.luxoft.trade.service.TransactionValidator;

@RestController
@RequestMapping("/validate")
public class LuxoftTradeController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(LuxoftTradeController.class);


	    @RequestMapping(value = "/data", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<String> infoForTrade(@RequestBody TradeTransactionRequest requestBean) throws Exception {
	        LOGGER.info("intitate");
	        try {
	        	TransactionValidator transactionValidator = TransactionValidatorFactory.getTransactionValidatorByType(requestBean);
	        	transactionValidator.validate();
	        	return transactionValidator.getErrorList();
	        }
	        catch (Exception e){
	            throw e;

	        }
	    }

}
