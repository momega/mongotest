package org.momega.mongotest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {
	
	private String mongoUrl = "mongodb://username:password@hostname:port/database";
	
	@Bean
	public MongoClientURI uri() {
		MongoClientURI uri= new MongoClientURI(mongoUrl);
		return uri;
	}

	@Override
	protected String getDatabaseName() {
		return uri().getDatabase();
	}

	@Override
	public Mongo mongo() throws Exception {
		 return new MongoClient(uri());
	}

}

