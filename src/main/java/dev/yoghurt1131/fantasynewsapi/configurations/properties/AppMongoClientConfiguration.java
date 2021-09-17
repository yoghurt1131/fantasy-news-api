package dev.yoghurt1131.fantasynewsapi.configurations.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("app.mongo.client")
@Data
public class AppMongoClientConfiguration {

    private String hostname = "localhost";

    private int port = 27017;

    private String dbname = "fantasy-news";

}
