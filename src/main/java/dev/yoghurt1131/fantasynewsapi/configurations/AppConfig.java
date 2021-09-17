package dev.yoghurt1131.fantasynewsapi.configurations;

import com.mongodb.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig  extends AbstractMongoClientConfiguration {

    @Bean
    public MongoClientFactoryBean mongoClientFactoryBean() {
        MongoClientFactoryBean factoryBean = new MongoClientFactoryBean();
        factoryBean.setHost("localhost");
        factoryBean.setPort(27017);
        return factoryBean;
    }

    @Bean
    public MongoClient mongoClient(MongoClientFactoryBean factoryBean) throws Exception {
        return factoryBean.getObject();
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, getDatabaseName());
    }

    @Override
    protected String getDatabaseName() {
        return "fantasy-news";
    }
}
