package com.vedantu.request;

import java.util.List;

public class OrderRequest {
	
	private List<ItemRequest> items;
	
	private Boolean isCouponCodeApplicable;
	
	private Boolean isCouponCodeApplied;
	
	private String couponCode;
	
	private Double actualPrice;
	
	private Double discount;

	public List<ItemRequest> getItems() {
		return items;
	}

	public void setItems(List<ItemRequest> items) {
		this.items = items;
	}

	public Boolean getIsCouponCodeApplicable() {
		return isCouponCodeApplicable;
	}

	public void setIsCouponCodeApplicable(Boolean isCouponCodeApplicable) {
		this.isCouponCodeApplicable = isCouponCodeApplicable;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Boolean getIsCouponCodeApplied() {
		return isCouponCodeApplied;
	}

	public void setIsCouponCodeApplied(Boolean isCouponCodeApplied) {
		this.isCouponCodeApplied = isCouponCodeApplied;
	}

	public Double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
}
