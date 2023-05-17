package com.osmanaltunay.questApp.responses;

import com.osmanaltunay.questApp.entities.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GetPostResponse {
    private Long id;
    private Long userId;
    private String userName;
    private String title;
    private String text;
    private List<GetLikeResponse> likes;

    public GetPostResponse(Post post, List<GetLikeResponse> likes){
        this.text = post.getText();
        this.id = post.getId();
        this.title = post.getTitle();
        this.userName = post.getUser().getUsername();
        this.userId = post.getUser().getId();
        this.likes = likes;
    }
}
