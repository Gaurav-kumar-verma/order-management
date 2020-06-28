package com.vedantu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vedantu.request.OrderRequest;
import com.vedantu.service.OrderService;
import com.vedantu.util.AppUtil;
import com.vedantu.util.ResponseUtil;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Object> createOrder(@RequestBody final OrderRequest orderRequest,
			@RequestParam(value = "userId") Long userId) {

		LOGGER.debug("REQUEST POST - /order Request to place order with details : {}", AppUtil.toJson(orderRequest));

		HttpHeaders headers = new HttpHeaders();
		Long orderId = orderService.createOrder(orderRequest , userId);

		LOGGER.debug("RESPONSE POST - /order is {}", AppUtil.toJson(orderId));
		return ResponseUtil.sendResponse(orderId, headers, HttpStatus.OK);
	}

}
