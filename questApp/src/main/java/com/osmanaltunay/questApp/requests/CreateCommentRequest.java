package com.osmanaltunay.questApp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCommentRequest {
    private Long id;
    private String text;
    private Long userId;
    private Long postId;
}
