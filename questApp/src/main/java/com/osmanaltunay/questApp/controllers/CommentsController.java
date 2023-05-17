package com.osmanaltunay.questApp.controllers;

import com.osmanaltunay.questApp.entities.Comment;
import com.osmanaltunay.questApp.requests.CreateCommentRequest;
import com.osmanaltunay.questApp.requests.UpdateCommentRequest;
import com.osmanaltunay.questApp.responses.GetCommentsResponse;
import com.osmanaltunay.questApp.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentsController {
    private CommentService commentService;

    @GetMapping
    public List<GetCommentsResponse> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return commentService.getAllComments(userId,postId);

    }
    @PostMapping
    public Comment createComment(@RequestBody CreateCommentRequest newComment){
        System.out.println(newComment.getText());
        System.out.println(newComment.getId());
        System.out.println(newComment.getUserId());
        System.out.println(newComment.getPostId());
        return commentService.creatComment(newComment);
    }
    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId){
        return commentService.getCommentById(commentId);
    }
    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest updateComment){
        return commentService.updateComment(commentId,updateComment);
    }
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }

}
