package com.bloggershub.BloggersHub.service;

import com.bloggershub.BloggersHub.model.Article;

import java.util.List;

public interface ArticleService {
    void save(Article article);

    Article findById(Integer id);

    List<Article> findByAuthorId(Integer id);
}
