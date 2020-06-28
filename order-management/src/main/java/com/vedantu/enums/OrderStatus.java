package com.vedantu.enums;

public  enum OrderStatus {
	
	ORDER_CREATED("Order Created", 1),
	ORDER_PLACED("Order Placed", 2),
	PAYMENT_DONE("Payment Done", 3),
	ORDER_CANCELLED("Order Cancel", 4),
	ORDER_DELIVERED("Order Delivered", 5),
	ORDER_SHIPPING("Order Shipping", 6)
	;
	
	public final String display;
	public final Integer value;
	
	private OrderStatus(String display, Integer value)
	{
		this.display = display;
		this.value = value;
	}

}
