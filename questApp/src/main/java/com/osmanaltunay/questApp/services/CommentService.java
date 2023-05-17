package com.osmanaltunay.questApp.services;

import com.osmanaltunay.questApp.entities.Comment;
import com.osmanaltunay.questApp.entities.Post;
import com.osmanaltunay.questApp.entities.User;
import com.osmanaltunay.questApp.repos.CommentRepository;
import com.osmanaltunay.questApp.requests.CreateCommentRequest;
import com.osmanaltunay.questApp.requests.UpdateCommentRequest;
import com.osmanaltunay.questApp.responses.GetCommentsResponse;
import com.osmanaltunay.questApp.responses.GetPostResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    @Transactional
    public List<GetCommentsResponse> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        List<Comment> comment;
        if(userId.isPresent() && postId.isEmpty())
            comment = commentRepository.findByUserId(userId.get());
        else if (userId.isEmpty() && postId.isPresent()) {
            comment = commentRepository.findByPostId(postId.get());
        }
        else if (userId.isPresent())
            comment= commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
        else
            comment =  commentRepository.findAll();
        return comment.stream().map(GetCommentsResponse::new).collect(Collectors.toList());
    }

    public Comment creatComment(CreateCommentRequest newComment) {
        System.out.println("Omdsnapfmalks");
        User user = userService.getUserById(newComment.getUserId());
        Post post = postService.getPostById(newComment.getPostId());
        System.out.println();
        if(user != null && post != null) {
            Comment comment = new Comment();
            comment.setUser(user);
            comment.setPost(post);
            comment.setId(newComment.getId());
            comment.setText(newComment.getText());
            return commentRepository.save(comment);
        }else
            return null;
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment updateComment(Long commentId, UpdateCommentRequest updateComment) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()){
            Comment toComment = comment.get();
            toComment.setText(updateComment.getText());
            return commentRepository.save(toComment);
        }else
            return null;
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);

    }
}
