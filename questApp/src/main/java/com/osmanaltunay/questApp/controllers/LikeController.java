package com.osmanaltunay.questApp.controllers;

import com.osmanaltunay.questApp.entities.Like;
import com.osmanaltunay.questApp.requests.CreateLikeRequest;
import com.osmanaltunay.questApp.responses.GetLikeResponse;
import com.osmanaltunay.questApp.services.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
@AllArgsConstructor
public class LikeController {
    private LikeService likeService;

    @GetMapping
    public List<GetLikeResponse> getAllLikes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return likeService.getAllLikes(userId,postId);

    }
    @PostMapping
    public Like createLike(@RequestBody CreateLikeRequest newLike){
        return likeService.createLike(newLike);

    }
    @GetMapping("/{likeId}")
    public GetLikeResponse getLikeById(@PathVariable Long likeId){
        return likeService.getLikeById(likeId);

    }
    @DeleteMapping("/{likeId}")
    public void deleteLike(@PathVariable Long likeId){
        likeService.deleteLike(likeId);

    }


}
