package com.vedantu.repository.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.mongodb.WriteResult;

public class IdSequenceGeneratorRepositoryImpl implements com.vedantu.repository.IdSequenceGeneratorCustomRepository {
	
	@Autowired MongoTemplate template;

	@Override
	public boolean insertReleaseLock(String type,boolean toSet) {
		StringBuffer searchQuery = new StringBuffer("");
		searchQuery.append("{type:'" +type+"',locked : "+!toSet+"}");
		Update update = new Update();
		update.set("locked", toSet);
		Query query = new BasicQuery(searchQuery.toString());
		WriteResult result = template.updateFirst(query,update,com.vedantu.model.IdSequenceGenerator.class);
		return result.isUpdateOfExisting();
		
	}

}
