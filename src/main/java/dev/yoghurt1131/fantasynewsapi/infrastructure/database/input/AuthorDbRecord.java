package dev.yoghurt1131.fantasynewsapi.infrastructure.database.input;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@Document
public class AuthorDbRecord {

    @Id
    UUID id;

    String name;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;


}
