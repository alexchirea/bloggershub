package com.bloggershub.BloggersHub.repository;

import com.bloggershub.BloggersHub.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByArticleId(Integer id);
}
