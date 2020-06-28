package com.vedantu.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.vedantu.model.IdSequenceGenerator;

@Component
public interface IdSequenceGeneratorRepository
		extends PagingAndSortingRepository<IdSequenceGenerator, String>, IdSequenceGeneratorCustomRepository {

	IdSequenceGenerator findByType(String type);

}
