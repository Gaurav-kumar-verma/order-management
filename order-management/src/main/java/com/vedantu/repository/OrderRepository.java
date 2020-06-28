package com.vedantu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import com.vedantu.model.Order;

@Component
public interface OrderRepository extends MongoRepository<Order , Long> {
	
	

}
