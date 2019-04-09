package com.bloggershub.BloggersHub.web;

import com.bloggershub.BloggersHub.model.Article;
import com.bloggershub.BloggersHub.model.User;
import com.bloggershub.BloggersHub.repository.ArticleRepository;
import com.bloggershub.BloggersHub.repository.UserRepository;
import com.bloggershub.BloggersHub.service.ArticleService;
import com.bloggershub.BloggersHub.validator.ArticleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value={"/my", "/", ""})
    public String myArticles(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User user = userRepository.findByUsername(username);
        List<Article> articles = articleRepository.findByAuthorId(user.getId());
        model.addAttribute("articles", articles);
        return "list-articles";
    }


    @GetMapping("/new")
    public String newArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "article-form";
    }

    @PostMapping("/save")
    public String saveArticle(@ModelAttribute("article") Article article) {
        if (article.getId() == 0) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails)principal).getUsername();
            User user = userRepository.findByUsername(username);
            article.setAuthorId(user.getId());
            article.setVotes(0);
            article.setViews(0);
        }
        else {
            Article copy = articleRepository.findById(article.getId());
            article.setAuthorId(copy.getAuthorId());
            article.setVotes(copy.getVotes());
            article.setViews(copy.getViews());
        }
        articleService.save(article);
        return "redirect:/articles/my";
    }

    @GetMapping("/update")
    public String updateArticleForm(@RequestParam("articleId") int id, Model model) {
        Article article = articleService.findById(id);
        model.addAttribute("article", article);
        return "article-form";
    }

    @GetMapping("/delete")
    public String deleteArticle(@RequestParam("articleId") int id) {
        articleService.deleteArticle(id);
        return "redirect:/articles/my";
    }

    @GetMapping("/publish")
    public String publishArticle(@RequestParam("articleId") int id) {
        Article article = articleRepository.findById(id);
        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        article.setPublished(currentTimestamp.toString());
        articleService.save(article);
        return "redirect:/articles/my";
    }

    @GetMapping("/unpublish")
    public String unpublishArticle(@RequestParam("articleId") int id) {
        Article article = articleRepository.findById(id);
        article.setPublished(null);
        articleService.save(article);
        return "redirect:/articles/my";
    }

}
