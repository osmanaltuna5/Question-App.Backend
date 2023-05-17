package com.osmanaltunay.questApp.repos;

import com.osmanaltunay.questApp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByUserId(Long aLong);

    List<Comment> findByPostId(Long aLong);

    List<Comment> findByUserIdAndPostId(Long userId, Long postId);
}
