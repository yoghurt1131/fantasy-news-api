package dev.yoghurt1131.fantasynewsapi.configurations.beanconfig;

import com.mongodb.client.MongoClient;
import dev.yoghurt1131.fantasynewsapi.configurations.properties.AppMongoClientConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class InfrastructureConfig extends AbstractMongoClientConfiguration {

    @Autowired
    AppMongoClientConfiguration configuration;

    @Bean
    public MongoClientFactoryBean mongoClientFactoryBean() {
        MongoClientFactoryBean factoryBean = new MongoClientFactoryBean();
        factoryBean.setHost(configuration.getHostname());
        factoryBean.setPort(configuration.getPort());
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
        return configuration.getDbname();
    }
}
