package dev.yoghurt1131.fantasynewsapi.resolver;

import dev.yoghurt1131.fantasynewsapi.graphql.input.CreateArticleInput;
import dev.yoghurt1131.fantasynewsapi.graphql.input.CreateAuthorInput;
import dev.yoghurt1131.fantasynewsapi.graphql.input.EditArticleInput;
import dev.yoghurt1131.fantasynewsapi.graphql.input.PostCommentInput;
import dev.yoghurt1131.fantasynewsapi.graphql.payload.ArticlePayload;
import dev.yoghurt1131.fantasynewsapi.graphql.payload.AuthorPayload;
import dev.yoghurt1131.fantasynewsapi.graphql.payload.CommentPayload;
import graphql.kickstart.tools.GraphQLMutationResolver;

import java.util.Collections;
import java.util.UUID;

public class FantasyNewsApiMutationResolver implements GraphQLMutationResolver {

    public CommentPayload postComment(PostCommentInput commentInput) {

        return new CommentPayload(UUID.randomUUID(), UUID.randomUUID(),
                "body", "anonymous lion", "20210723",
                Collections.emptyList());
    }

    public AuthorPayload createAuthor(CreateAuthorInput authorInput) {
        return new AuthorPayload("smith");
    }

    public ArticlePayload createArticle(CreateArticleInput articleInput) {
        return new ArticlePayload(UUID.randomUUID(),
                "title", "body", new AuthorPayload("smith"),
                "imageUrl", Collections.emptyList(),
                "20210723000000", Collections.emptyList(),
                0, 1);
    }

    public ArticlePayload editArticle(EditArticleInput articleInput) {
        return new ArticlePayload(UUID.randomUUID(),
                "title", "body", new AuthorPayload("smith"),
                "imageUrl", Collections.emptyList(),
                "20210723000000", Collections.emptyList(),
                0, 1);
    }
}
