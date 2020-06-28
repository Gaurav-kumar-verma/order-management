package com.vedantu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.vedantu.model.Account;

@Component
public interface AccountRepository extends MongoRepository<Account , Long> {
	
	Account findByUserId(Long userId);

}
