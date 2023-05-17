package com.osmanaltunay.questApp.responses;

import com.osmanaltunay.questApp.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetCommentsResponse {
    private Long id;
    private Long userId;
    private String userName;
    private String text;
    public GetCommentsResponse(Comment comment){
        this.id = comment.getId();
        this.userId =comment.getUser().getId();
        this.userName= comment.getUser().getUsername();
        this.text = comment.getText();

    }
}
