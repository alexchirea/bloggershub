package com.bloggershub.BloggersHub.web;

import com.bloggershub.BloggersHub.model.Article;
import com.bloggershub.BloggersHub.model.Comments;
import com.bloggershub.BloggersHub.repository.ArticleRepository;
import com.bloggershub.BloggersHub.service.ArticleService;
import com.bloggershub.BloggersHub.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping(value={"/", ""})
public class HomeController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @GetMapping(value={"/", "", "/home"})
    public String home(ModelMap model) {
        List<Article> articles = articleService.findAllPublished();
        model.addAttribute("articles", articles);
        return "home";
    }

    @GetMapping("/article")
    public String viewArticle(@RequestParam("articleId") int id, Model model) {
        Article article = articleService.findById(id);
        List<Comments> comments = commentService.findByArticleId(id);
        model.addAttribute("article", article);
        model.addAttribute("comment", new Comments());
        model.addAttribute("comments", comments);
        article.setViews(article.getViews() + 1);
        articleService.save(article);
        return "view-article";
    }

    @GetMapping("/like")
    public String likeArticle(@RequestParam("articleId") int id, Model model) {
        Article article = articleService.findById(id);
        article.setVotes(article.getVotes()+1);
        articleService.save(article);
        return "redirect:/article?articleId=" + id;
    }

    @GetMapping("/dislike")
    public String dislikeArticle(@RequestParam("articleId") int id, Model model) {
        Article article = articleService.findById(id);
        article.setVotes(article.getVotes()-1);
        articleService.save(article);
        return "redirect:/article?articleId=" + id;
    }

}
