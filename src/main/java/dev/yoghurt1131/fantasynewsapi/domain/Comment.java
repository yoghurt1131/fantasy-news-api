package dev.yoghurt1131.fantasynewsapi.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public class Comment {

    private UUID commentId;

    private String body;

    private String user;

    private LocalDateTime postedAt;

    private List<Comment> childComments;
}
