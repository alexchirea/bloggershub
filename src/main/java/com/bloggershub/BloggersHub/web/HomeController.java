package com.bloggershub.BloggersHub.web;

import com.bloggershub.BloggersHub.model.Article;
import com.bloggershub.BloggersHub.repository.ArticleRepository;
import com.bloggershub.BloggersHub.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value={"/", ""})
public class HomeController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value={"/", "", "/home"})
    public String home(ModelMap model) {
        List<Article> articles = articleService.findAllPublished();
        model.addAttribute("articles", articles);
        return "home";
    }

    @GetMapping("/article")
    public String viewArticle(@RequestParam("articleId") int id, Model model) {
        Article article = articleService.findById(id);
        model.addAttribute("article", article);
        return "view-article";
    }

}
