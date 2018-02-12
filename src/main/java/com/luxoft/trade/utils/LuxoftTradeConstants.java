package com.luxoft.trade.utils;

public class LuxoftTradeConstants {
	
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final int DAY_SATURDAY = 6;
	public static final int DAY_SUNDAY = 7;
	public static final String CONSUMER_PLUTO1 = "PLUTO1";
	public static final String CONSUMER_PLUTO2 = "PLUTO2";
	public static final String STYLE_AMERICAN = "American";
	public static final String STYLE_EUROPEAN = "European";
	public static final String LEGAL_ENTITY  = "CS Zurich";
	
	//ErrorMessages
	public static final String VALUE_DATE_EMPTY_OR_NULL = "value date cant be null with this product type";
	public static final String TRADE_DATE_EMPTY_OR_NULL = "trade date cant be null with this product type";
	public static final String VALUE_DATE_ON_WEEKEND = "ValueDate can not be a saturay or sunday";
	public static final String VALUE_DATE_BEFORE_TRADE_DATE = "ValueDate can not be Before TradeDate";
	public static final String VALID_CUSTOMER_TYPES = "Allowed customer types are only pluto1 and pluto2";
	public static final String CUSTOMER_TYPE_EMPTY_OR_NULL = "Customer type can not be empty or null";
	public static final String PAY_CURRENCY_EMPTY_OR_NULL = "pay currency can not be empty or null";
	public static final String INVALID_PAY_CURRENCY = "invalid pay currency";
	public static final String PREMIUM_CURRENCY_EMPTY_OR_NULL = "pay currency can not be empty or null";
	public static final String INVALID_PREMIUM_CURRENCY = "invalid premium currency";
	public static final String EXERCISE_START_DATE_EMPTY_OR_NULL = "exercise start date can not be empty or null";;
	public static final String EXPIRY_DATE_EMPTY_OR_NULL = "expiry date can not be empty or null";;
	public static final String PREMIUM_DATE_EMPTY_OR_NULL = "premium date can not be empty or null";;
	public static final String DELIVERY_DATE_EMPTY_OR_NULL = "delivery date can not be empty or null";
	public static final String STYLE_EMPTY_OR_NULL = "Style can not be empty or null";
	public static final String INVALID_STYLE = "Invalid style";
	public static final String EXERCISE_DATE_BEFORE_TRADE_DATE = "exerciseStartDate can not be Before TradeDate";
	public static final String EXERCISE_DATE_AFTER_EXPIRY_DATE = "exerciseStartDate can not be after expiry date";
	public static final String EXERCISE_DATE_AFTER_DELIVERY_DATE = "expiryDate can not be after deliveryDate";
	public static final String PREMIUM_DATE_AFTER_DELIVERY_DATE = "premiumDate can not be after deliveryDate";
	public static final String LEGAL_ENTITY_EMPTY_OR_NULL = "legal entity can not be null or empty";
	public static final String INVALID_LEGAL_ENTITY = "Invalid legal entity";
	
	//Global Exception Message
	public static final String GLOBAL_EXCEPTION_MESSAGE = "oops!! Service not available.";
	
}
