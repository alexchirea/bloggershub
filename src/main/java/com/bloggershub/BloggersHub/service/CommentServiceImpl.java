package com.bloggershub.BloggersHub.service;


import com.bloggershub.BloggersHub.model.Comments;
import com.bloggershub.BloggersHub.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comments comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comments> findByArticleId(Integer id) {
        return commentRepository.findByArticleId(id);
    }
}
