package com.osmanaltunay.questApp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLikeRequest {
    private Long id;
    private Long userId;
    private Long postId;
}
