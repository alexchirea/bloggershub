package com.bloggershub.BloggersHub.service;


import com.bloggershub.BloggersHub.model.Comments;

import java.util.List;

public interface CommentService {
    void save(Comments comment);

    List<Comments> findByArticleId(Integer id);
}
