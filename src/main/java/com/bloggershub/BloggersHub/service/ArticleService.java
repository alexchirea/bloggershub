package com.bloggershub.BloggersHub.service;

import com.bloggershub.BloggersHub.model.Article;

import java.util.List;

public interface ArticleService {
    void save(Article article);

    List<Article> findByAuthorId(Integer id);

    void deleteArticle(int id);

    Article findById(int id);
}
