package com.osmanaltunay.questApp.repos;

import com.osmanaltunay.questApp.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like,Long> {

    List<Like> findByUserId(Long userId);

    List<Like> findByPostId(Long postId);

    List<Like> findByUserIdAndPostId(Long userId, Long postId);
}
