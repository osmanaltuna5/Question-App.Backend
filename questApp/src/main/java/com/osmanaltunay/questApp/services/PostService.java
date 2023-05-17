package com.osmanaltunay.questApp.services;

import com.osmanaltunay.questApp.entities.Post;
import com.osmanaltunay.questApp.entities.User;
import com.osmanaltunay.questApp.repos.PostRepository;
import com.osmanaltunay.questApp.requests.CreatePostRequest;
import com.osmanaltunay.questApp.requests.UpdatePostRequest;
import com.osmanaltunay.questApp.responses.GetLikeResponse;
import com.osmanaltunay.questApp.responses.GetPostResponse;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;
    private LikeService likeService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }
    @Bean
    public LikeService setLikeService(LikeService likeService){
        return this.likeService = likeService;
    }

    @Transactional
    public List<GetPostResponse> getAllPost(Optional<Long> userId){
        List<Post> response ;
        if(userId.isPresent())
            response = postRepository.findByUserId(userId.get());
        else
            response = postRepository.findAll();
        return response.stream().map(post -> {List<GetLikeResponse> likes = likeService.getAllLikes(Optional.empty(),Optional.of(post.getId()));
        return new GetPostResponse(post,likes);}).collect(Collectors.toList());
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post creatPost(CreatePostRequest newPost) {
        User user = userService.getUserById(newPost.getUser_id());
        if (user == null)
            return null;
        else {
            Post post = new Post();
            post.setId(newPost.getId());
            post.setText(newPost.getText());
            post.setTitle(newPost.getTitle());
            post.setUser(user);
            return postRepository.save(post);
        }
    }

    public Post updateOnePostById(Long postId, UpdatePostRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()){
            post.get().setText(updatePost.getText());
            post.get().setTitle(updatePost.getTitle());
            postRepository.save(post.get());
            return post.get();

        }else
            return null;
    }

    public void deleteOnePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
