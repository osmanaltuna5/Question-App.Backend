package com.osmanaltunay.questApp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {
    private Long id;
    private String title;
    private String text;
    private Long user_id;
}
