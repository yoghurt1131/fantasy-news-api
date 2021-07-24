package dev.yoghurt1131.fantasynewsapi.resolver;

import dev.yoghurt1131.fantasynewsapi.graphql.ArticleCategory;
import dev.yoghurt1131.fantasynewsapi.graphql.payload.ArticlePayload;
import dev.yoghurt1131.fantasynewsapi.graphql.payload.AuthorPayload;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ArticleQueryResolver implements GraphQLQueryResolver {

   public List<ArticlePayload> latestArticles(int limit) {
       log.info("call latestArticles.");
       ArticlePayload articlePayload = new ArticlePayload(UUID.randomUUID(),
               "title", "body", new AuthorPayload("bob"),
               "imageUrl", Collections.emptyList(),
               "20210723000000", Collections.emptyList(),
               0, 1);
       return Arrays.asList(articlePayload);
   }

   public ArticlePayload getArticleById(UUID articleId) {
       log.info("call getArticleById.");
       return new ArticlePayload(UUID.randomUUID(),
               "title", "body", new AuthorPayload("bob"),
               "imageUrl", Collections.emptyList(),
               "20210723000000", Collections.emptyList(),
               0, 1);
   }

   public List<ArticlePayload> getArticlesByCategory(ArticleCategory category) {
       return Collections.emptyList();
   }

   public List<ArticlePayload> getArticleHistory(UUID articleId) {
       return Collections.emptyList();
   }
}
