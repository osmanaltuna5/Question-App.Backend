package com.osmanaltunay.questApp.controllers;

import com.osmanaltunay.questApp.entities.Post;
import com.osmanaltunay.questApp.requests.CreatePostRequest;
import com.osmanaltunay.questApp.requests.UpdatePostRequest;
import com.osmanaltunay.questApp.responses.GetPostResponse;
import com.osmanaltunay.questApp.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping
    public List<GetPostResponse> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.getAllPost(userId);
    }
    @PostMapping
    public Post createPost(@RequestBody CreatePostRequest newPost){
        return postService.creatPost(newPost);

    }
    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);

    }
    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody UpdatePostRequest updatePost){
        return postService.updateOnePostById(postId,updatePost);
    }
    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deleteOnePost(postId);
    }



}
