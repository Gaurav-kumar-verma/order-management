package com.vedantu.config;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;

@Configuration
public class MongoConfig {
	
	private Logger logger = LoggerFactory.getLogger(MongoConfig.class);

	private @Value("${spring.data.mongodb.uri}") String uri;
	
	@Bean(name = {"mongoTemplate"})
	public MongoTemplate getMongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
		mongoTemplate.setWriteConcern(WriteConcern.SAFE);
		checkDBConnection(mongoTemplate);
		return mongoTemplate;
	}
	
	@Bean(name = {"mongoDbFactory"})
	public MongoDbFactory getMongoDbFactory() throws UnknownHostException {
		
		 MongoClientURI clientURI = new MongoClientURI(uri);
	        
	     MongoClient mongoClient = new MongoClient(clientURI);
	        
		 return new SimpleMongoDbFactory(clientURI);
	}
	
	public Mongo getMongo() throws UnknownHostException {
		MongoClientURI clientURI = new MongoClientURI(uri);
		return new MongoClient(clientURI);
	}

	
	private void checkDBConnection(MongoTemplate mongoTemplate) {
		try {
			mongoTemplate.getDb();
			logger.info("Successfully connected to MongoDB");
		} catch (Exception ex) {
			logger.error("Could not connect to MongoDB. host: " + uri);
			throw new RuntimeException("Could not connect to MongoDB. Reason: " + ex.getMessage());
		}
	}
	
}
