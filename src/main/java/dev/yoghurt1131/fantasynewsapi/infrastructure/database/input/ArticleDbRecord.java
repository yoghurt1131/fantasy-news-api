package dev.yoghurt1131.fantasynewsapi.infrastructure.database.input;

import dev.yoghurt1131.fantasynewsapi.domain.Category;
import dev.yoghurt1131.fantasynewsapi.domain.Comment;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@Document(collection = "article")
public class ArticleDbRecord {

    @Id
    String id;

    String title;

    String body;

    String authorId;

    String authorName;

    String imageUrl;

    List<Category> categories;

    LocalDateTime publishedAt;

    List<Comment> comments;

    int version;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

}
