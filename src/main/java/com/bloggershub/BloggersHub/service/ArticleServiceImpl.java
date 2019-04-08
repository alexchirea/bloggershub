package com.bloggershub.BloggersHub.service;


import com.bloggershub.BloggersHub.model.Article;
import com.bloggershub.BloggersHub.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Article findById(Integer id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> findByAuthorId(Integer id) {
        return articleRepository.findByAuthorId(id);
    }


}
