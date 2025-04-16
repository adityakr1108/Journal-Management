package com.edigest.journal.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.data.mongodb.MongoTransactionManager;
@SpringBootApplication
@EnableTransactionManagement
@EnableMongoRepositories(basePackages = "com.edigest.journal.app.repository")
public class JournalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalAppApplication.class, args);
	}


	@Bean
    public PlatformTransactionManager add(MongoDatabaseFactory dbfactory) {
        return new MongoTransactionManager(dbfactory);
    }
}
