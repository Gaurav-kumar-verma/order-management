package com.vedantu.validator;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vedantu.exception.AppRuntimeException;
import com.vedantu.model.Inventory;
import com.vedantu.model.Item;
import com.vedantu.repository.InventoryRepository;
import com.vedantu.repository.ItemRepository;
import com.vedantu.request.ItemRequest;
import com.vedantu.request.OrderRequest;

@Component
public class OrderValidator implements Validator{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private InventoryRepository inventoryReposiotry;
	
	@Override
	public boolean validate(Object object) throws AppRuntimeException{
		
		OrderRequest orderRequest = (OrderRequest) object;
		
		if(orderRequest == null)
			throw new AppRuntimeException("Blank Request");
		
		// validate item Id in system
		List<ItemRequest> items = orderRequest.getItems();
		List<Long> itemIds = items.stream().map(item -> item.getItemId()).collect(Collectors.toList());
		
		List<Item> itemList = itemRepository.findByIdIn(itemIds);
		
		if(itemList == null || itemList.isEmpty())
			throw new AppRuntimeException("No Item present in System related to Given Ids.");
		
		if(itemList.size() != itemIds.size())
			throw new AppRuntimeException("Few of Item not present in System related to Given Ids.");
		
		// check for inventory
		List<Inventory> inventories = inventoryReposiotry.findByItemIdIn(itemIds);
		
		if(inventories.size() != itemIds.size()) {
			throw new AppRuntimeException("Some Items are not available in Inventory.");
		}
		
		for(ItemRequest item :  items) { 
			for(Inventory inv : inventories) {
				if(inv.getItemId() == item.getItemId() && inv.getRemainingQuantity() < item.getQuantity()) {
					throw new AppRuntimeException("Inventory is not sufficient for Item : {} " + item.getItemId());
				}
			}
		}
		
		// check for coupon code
		if(!orderRequest.getIsCouponCodeApplicable() && orderRequest.getCouponCode() != null)
			throw new AppRuntimeException("Coupn Code is not applicable for this order");
		
		// check for discount
		if(orderRequest.getDiscount() < 0 || orderRequest.getDiscount() > 100) 
			throw new AppRuntimeException("Invalid value for Discount");
		
		return true;
	}
}
