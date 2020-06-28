package com.vedantu.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.vedantu.enums.OrderStatus;
import com.vedantu.request.ItemRequest;

@Document(collection="order")
public class Order extends BaseEntity {
	
	@Field("items")
	private List<ItemRequest> items;
	
	@Field("discount")
	private Double discount; // if any  
	
	@Field("is_coupon_code_applied")
	private Boolean isCouponCodeApplied; // for handling coupon code
	
	@Field("is_coupon_code_applicable")
	private Boolean isCouponCodeApplicable; // for handling coupon code
	
	@Field("coupon_code")
	private String couponCode;
	
	@Field("is_order_confirmed")
	private Boolean isOrderConfirmed;
	
	@Field("user_id")
	private Long userId;
	
	@Field("user_name")
	private String userName; // name to be shown where we will show order
	
	@Field("is_payment_done")
	private Boolean isPaymentDone;
	
	@Field("order_status")
	private OrderStatus orderStatus; // created , placed , cancelled , delivered
	
	@Field("payment_mode")
	private String paymentMode;
	
	@Field("actual_price")
	private Double actualPrice;
	
	@Field("discounted_price")
	private Double discountedPrice;
	
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public List<ItemRequest> getItems() {
		return items;
	}

	public void setItems(List<ItemRequest> items) {
		this.items = items;
	}

	public Boolean getIsCouponCodeApplied() {
		return isCouponCodeApplied;
	}

	public void setIsCouponCodeApplied(Boolean isCouponCodeApplied) {
		this.isCouponCodeApplied = isCouponCodeApplied;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Boolean getIsOrderConfirmed() {
		return isOrderConfirmed;
	}

	public void setIsOrderConfirmed(Boolean isOrderConfirmed) {
		this.isOrderConfirmed = isOrderConfirmed;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Boolean getIsPaymentDone() {
		return isPaymentDone;
	}

	public void setIsPaymentDone(Boolean isPaymentDone) {
		this.isPaymentDone = isPaymentDone;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Boolean getIsCouponCodeApplicable() {
		return isCouponCodeApplicable;
	}

	public void setIsCouponCodeApplicable(Boolean isCouponCodeApplicable) {
		this.isCouponCodeApplicable = isCouponCodeApplicable;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

}
