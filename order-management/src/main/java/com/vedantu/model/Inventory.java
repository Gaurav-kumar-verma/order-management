package com.vedantu.model;

public class Inventory extends BaseEntity {
	
	private Long itemId;
	
	private Long totalQuantity;
	
	private Long remainingQuantity;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Long getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(Long remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}
	
}
