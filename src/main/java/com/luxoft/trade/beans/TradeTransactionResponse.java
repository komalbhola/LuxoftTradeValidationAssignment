package com.luxoft.trade.beans;

public class TradeTransactionResponse<T> {
	
	private Status status;
	private T result;
	
	private static final Status successStatus = new Status(200,"Success");
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	
	public static <P> TradeTransactionResponse<P> getSuccessResponse(P result){
		TradeTransactionResponse<P> response = new TradeTransactionResponse<P>();
		response.setStatus(successStatus);
		response.setResult(result);
		return response;
	}

}
