package dev.yoghurt1131.fantasynewsapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record Article (
    @JsonProperty
    String title,
    @JsonProperty
    String headline,
    @JsonProperty
    String imageUrl,
    @JsonProperty
    String body,
    @JsonProperty
    String author,
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    LocalDateTime postedAt
) {
   public static Article build(ArticleRecord record) {
       var article = new Article(
               record.title(),
               record.headline(),
               record.image_url(),
               record.body(),
               record.author(),
               record.posted_at()
       );
       return article;
   }
}
