package dev.yoghurt1131.fantasynewsapi;

import dev.yoghurt1131.fantasynewsapi.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class FantasyNewsApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(FantasyNewsApiApplication.class, args);
	}
}
