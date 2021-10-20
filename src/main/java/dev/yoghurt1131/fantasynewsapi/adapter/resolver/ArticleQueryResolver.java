package dev.yoghurt1131.fantasynewsapi.adapter.resolver;

import dev.yoghurt1131.fantasynewsapi.adapter.resolver.payload.ArticlePayload;
import dev.yoghurt1131.fantasynewsapi.adapter.resolver.payload.AuthorPayload;
import dev.yoghurt1131.fantasynewsapi.domain.Category;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
public class ArticleQueryResolver implements GraphQLQueryResolver {

   public List<ArticlePayload> latestArticles(int limit) {
       log.info("call latestArticles.");
       ArticlePayload articlePayload = new ArticlePayload(UUID.randomUUID(),
               "title", "body", new AuthorPayload(UUID.randomUUID(), "bob"),
               "imageUrl", Collections.emptyList(),
               LocalDateTime.now(), Collections.emptyList(),
               0, 1);
       return Arrays.asList(articlePayload);
   }

   public ArticlePayload getArticleById(UUID articleId) {
       log.info("call getArticleById.");
       return new ArticlePayload(UUID.randomUUID(),
               "title", "body", new AuthorPayload(UUID.randomUUID(), "bob"),
               "imageUrl", Collections.emptyList(),
               LocalDateTime.now(), Collections.emptyList(),
               0, 1);
   }

    public ArticlePayload showArticleById(UUID articleId) {
        log.info("call showArticleById.");
        return new ArticlePayload(UUID.randomUUID(),
                "title", "body", new AuthorPayload(UUID.randomUUID(), "bob"),
                "imageUrl", Collections.emptyList(),
                LocalDateTime.now(), Collections.emptyList(),
                0, 1);
    }

   public List<ArticlePayload> getArticlesByCategory(Category category) {
       return Collections.emptyList();
   }

   public List<ArticlePayload> getArticleHistory(UUID articleId) {
       return Collections.emptyList();
   }
}
