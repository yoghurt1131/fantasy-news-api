package dev.yoghurt1131.fantasynewsapi.resolver;

import dev.yoghurt1131.fantasynewsapi.graphql.payload.ArticlePayload;
import dev.yoghurt1131.fantasynewsapi.graphql.payload.AuthorPayload;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

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

   public ArticlePayload getArticleById(UUID id) {
       log.info("call getArticleById.");
       return new ArticlePayload(UUID.randomUUID(),
               "title", "body", new AuthorPayload("bob"),
               "imageUrl", Collections.emptyList(),
               "20210723000000", Collections.emptyList(),
               0, 1);
   }


}
