package com.bloggershub.BloggersHub.service;


import com.bloggershub.BloggersHub.model.Article;
import com.bloggershub.BloggersHub.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Article> findByAuthorId(Integer id) {
        return articleRepository.findByAuthorId(id);
    }

    @Override
    @Transactional
    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> findAllPublished() {
        return articleRepository.findByPublishedNotNull();
    }

}
