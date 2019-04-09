package com.bloggershub.BloggersHub.web;

import com.bloggershub.BloggersHub.model.Article;
import com.bloggershub.BloggersHub.repository.ArticleRepository;
import com.bloggershub.BloggersHub.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value={"/", ""})
public class HomeController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value={"/", ""})
    public String home(ModelMap model) {
        List<Article> articles = articleService.findAllPublished();
        model.addAttribute("articles", articles);
        return "home";
    }

}