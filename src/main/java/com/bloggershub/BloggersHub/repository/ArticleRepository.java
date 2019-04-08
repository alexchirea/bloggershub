package com.bloggershub.BloggersHub.repository;

import com.bloggershub.BloggersHub.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findById(Integer id);
    List<Article> findByAuthorId(Integer id);
}
