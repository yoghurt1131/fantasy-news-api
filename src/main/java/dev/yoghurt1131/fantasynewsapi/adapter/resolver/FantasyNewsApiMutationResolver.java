package dev.yoghurt1131.fantasynewsapi.adapter.resolver;

import dev.yoghurt1131.fantasynewsapi.adapter.resolver.input.CreateArticleInput;
import dev.yoghurt1131.fantasynewsapi.adapter.resolver.input.CreateAuthorInput;
import dev.yoghurt1131.fantasynewsapi.adapter.resolver.input.EditArticleInput;
import dev.yoghurt1131.fantasynewsapi.adapter.resolver.input.PostCommentInput;
import dev.yoghurt1131.fantasynewsapi.adapter.resolver.payload.ArticlePayload;
import dev.yoghurt1131.fantasynewsapi.adapter.resolver.payload.AuthorPayload;
import dev.yoghurt1131.fantasynewsapi.adapter.resolver.payload.CommentPayload;
import dev.yoghurt1131.fantasynewsapi.application.NewsPublishUsecase;
import dev.yoghurt1131.fantasynewsapi.domain.Author;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@RequiredArgsConstructor
public class FantasyNewsApiMutationResolver implements GraphQLMutationResolver {

    private final NewsPublishUsecase publishUsecase;

    public CommentPayload postComment(PostCommentInput commentInput) {

        return new CommentPayload(UUID.randomUUID(), UUID.randomUUID(),
                "body", "anonymous lion", LocalDateTime.now(),
                Collections.emptyList());
    }

    public AuthorPayload createAuthor(CreateAuthorInput input) {
        Author author = publishUsecase.createAuthor(input.name());

        return new AuthorPayload(author.getId(), author.getName());
    }

    public ArticlePayload createArticle(CreateArticleInput input) {
        Author author = Author.builder()
                .id(input.authorId())
                .name(input.authorName())
                .build();
        return new ArticlePayload(UUID.randomUUID(),
                input.title(), input.body(), author.buildPayload(),
                input.imageUrl(), input.categories(),
                LocalDateTime.now(), Collections.emptyList(),
                0, 1);
    }

    public ArticlePayload editArticle(EditArticleInput articleInput) {
        return new ArticlePayload(UUID.randomUUID(),
                "title", "body", new AuthorPayload(UUID.randomUUID(),"smith"),
                "imageUrl", Collections.emptyList(),
                LocalDateTime.now(), Collections.emptyList(),
                0, 1);
    }
}
