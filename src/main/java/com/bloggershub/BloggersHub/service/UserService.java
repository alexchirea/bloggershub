package com.bloggershub.BloggersHub.service;

import com.bloggershub.BloggersHub.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User findById(Integer id);

}
