package com.bloggershub.BloggersHub.web;

import com.bloggershub.BloggersHub.model.Comments;
import com.bloggershub.BloggersHub.model.User;
import com.bloggershub.BloggersHub.repository.ArticleRepository;
import com.bloggershub.BloggersHub.repository.UserRepository;
import com.bloggershub.BloggersHub.service.ArticleService;
import com.bloggershub.BloggersHub.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    private String saveComment(@ModelAttribute("comments") Comments comments, BindingResult bindingResult, HttpServletRequest request) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        comments.setUsername(username);
        comments.setIp(request.getRemoteAddr());
        commentService.save(comments);
        return "redirect:/article?articleId=" + comments.getArticleId();

    }

}
