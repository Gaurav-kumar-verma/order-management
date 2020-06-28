package com.vedantu.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.vedantu.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, Long>{
	
	List<Inventory> findByItemIdIn(List<Long> itemId);

}
