package com.vedantu.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.vedantu.model.Item;

@Component
public interface ItemRepository extends MongoRepository<Item , Long> {
	
	List<Item> findByIdIn(List<Long> itemIds);
	
}
