package com.osmanaltunay.questApp.responses;

import com.osmanaltunay.questApp.entities.Like;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetLikeResponse {
    private Long id;
    private Long userId;
    private Long postId;
    public GetLikeResponse(Like like){
        this.id = like.getId();
        this.userId = like.getUser().getId();
        this.postId = like.getPost().getId();

    }
}
