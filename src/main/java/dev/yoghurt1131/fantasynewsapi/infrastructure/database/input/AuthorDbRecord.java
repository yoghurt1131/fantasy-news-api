package dev.yoghurt1131.fantasynewsapi.infrastructure.database.input;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document(collection = "author")
public class AuthorDbRecord {

    @Id
    String id;

    String name;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;


}
