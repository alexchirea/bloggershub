package com.bloggershub.BloggersHub.repository;

import com.bloggershub.BloggersHub.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByAuthorId(Integer id);
    Article findById(int id);
    void deleteById(int id);
    List<Article> findByPublishedNotNull();
}
