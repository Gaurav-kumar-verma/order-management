package com.vedantu.service;

import com.vedantu.request.OrderRequest;

public interface OrderService {
	
	Long createOrder(OrderRequest orderRequest,Long userId);

}
