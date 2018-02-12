package com.luxoft.trade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.luxoft.trade.beans.Status;
import com.luxoft.trade.beans.TradeTransactionResponse;
import com.luxoft.trade.utils.LuxoftTradeConstants;

@ControllerAdvice
public class LuxoftTradeExceptionHandler {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Throwable.class)
	public @ResponseBody TradeTransactionResponse handleExceptions(Exception exception){
		
		TradeTransactionResponse<Void> response = new TradeTransactionResponse<Void>();
		response.setStatus(new Status(500, LuxoftTradeConstants.GLOBAL_EXCEPTION_MESSAGE));
		return response;
	}

}
