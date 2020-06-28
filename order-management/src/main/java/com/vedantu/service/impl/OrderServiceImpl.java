package com.vedantu.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vedantu.enums.OrderStatus;
import com.vedantu.exception.AppRuntimeException;
import com.vedantu.model.Account;
import com.vedantu.model.Order;
import com.vedantu.repository.AccountRepository;
import com.vedantu.repository.OrderRepository;
import com.vedantu.request.OrderRequest;
import com.vedantu.service.IdSequenceGeneratorService;
import com.vedantu.service.OrderService;
import com.vedantu.util.AppConstant;
import com.vedantu.validator.OrderValidator;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private AccountRepository accountUserRepository;
	
	@Autowired
	private OrderValidator orderValidator;
	
	@Autowired
	private IdSequenceGeneratorService idSequenceGeneratorService;

	private static Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public Long createOrder(OrderRequest orderRequest, Long userId) throws AppRuntimeException {

		// validate User.
		Account accountUser = accountUserRepository.findByUserId(userId);
		if(accountUser == null)
			throw new AppRuntimeException("Invalid User ");
		
		// validate offer
		orderValidator.validate(orderRequest);

		// Place Order
		Order order = placeOrder(orderRequest , userId);

		LOGGER.debug("Order created successfully !!!! with Id : {}", order.getId());
		return order.getId();
	}

	private Order placeOrder(OrderRequest orderRequest , Long userId) {
			
		Order order = new Order();
		order.setUserId(userId);
		order.setItems(orderRequest.getItems());
		order.setIsCouponCodeApplied(orderRequest.getIsCouponCodeApplied());
		order.setIsCouponCodeApplicable(orderRequest.getIsCouponCodeApplicable());
		
		if(order.getIsCouponCodeApplicable() && order.getIsCouponCodeApplied()) 
			order.setCouponCode(orderRequest.getCouponCode());

		order.setActualPrice(orderRequest.getActualPrice());
		order.setDiscount(order.getDiscount());
		
		if(orderRequest.getDiscount() == null || orderRequest.getDiscount() == 0.0)
			order.setDiscountedPrice(orderRequest.getActualPrice());
		else {
			Double discountedPrice = (orderRequest.getActualPrice() * orderRequest.getDiscount()) / 100 ;
			order.setDiscountedPrice(discountedPrice);
		}
		
		order.setCreatedBy(userId);
		order.setUpdatedBy(userId);
		order.setIsPaymentDone(Boolean.FALSE);
		order.setIsOrderConfirmed(Boolean.FALSE);
		order.setOrderStatus(OrderStatus.ORDER_CREATED);
		order.setCreateAt(System.currentTimeMillis());
		order.setUpdatedAt(System.currentTimeMillis());
		order.setId(idSequenceGeneratorService.getNextSequenceByType(AppConstant.COLLECTION_TYPE.ORDER.type));
		
		orderRepository.save(order);
		
		return order;
		
	}

}
