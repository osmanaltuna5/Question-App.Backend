package com.osmanaltunay.questApp.services;

import com.osmanaltunay.questApp.entities.Like;
import com.osmanaltunay.questApp.entities.Post;
import com.osmanaltunay.questApp.entities.User;
import com.osmanaltunay.questApp.repos.LikeRepository;
import com.osmanaltunay.questApp.requests.CreateLikeRequest;
import com.osmanaltunay.questApp.responses.GetLikeResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LikeService {
    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;
    @Transactional
    public List<GetLikeResponse> getAllLikes(Optional<Long> userId, Optional<Long> postId) {
        List<Like> likes;
        if (userId.isPresent() && postId.isEmpty())
            likes = likeRepository.findByUserId(userId.get());
        else if (userId.isEmpty() && postId.isPresent())
            likes = likeRepository.findByPostId(postId.get());
        else if (userId.isPresent())
            likes = likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
        else
            likes = likeRepository.findAll();
        return likes.stream().map(GetLikeResponse::new).collect(Collectors.toList());
    }

    public Like createLike(CreateLikeRequest newLike) {
        User user = userService.getUserById(newLike.getUserId());
        Post post = postService.getPostById(newLike.getPostId());
        if (user != null && post != null){
            Like like = new Like();
            like.setUser(user);
            like.setPost(post);
            return likeRepository.save(like);
        }else
            return null;
    }

    public GetLikeResponse getLikeById(Long likeId) {
        Like like = likeRepository.findById(likeId).orElse(null);
        GetLikeResponse responseLike = new GetLikeResponse();
        if (like != null) {
            responseLike.setId(like.getId());
            responseLike.setUserId(like.getUser().getId());
            responseLike.setPostId(like.getPost().getId());
            return responseLike;
        }else
            return null;

    }

    public void deleteLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
