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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleValidator articleValidator;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/newarticle")
    public String newarticle(Model model) {
        model.addAttribute("articleForm", new Article());
        return "newarticle";
    }

    @PostMapping("/newarticle")
    public String newarticle(@ModelAttribute("articleForm") Article articleForm, BindingResult bindingResult) {
        articleValidator.validate(articleForm, bindingResult);


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User user = userRepository.findByUsername(username);

        articleForm.setAuthorId(user.getId());
        articleForm.setViews(0);
        articleForm.setVotes(0);

        if (bindingResult.hasErrors()) {
            return "newarticle";
        }

        articleService.save(articleForm);

        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User user = userRepository.findByUsername(username);
        List<Article> articleList = articleRepository.findByAuthorId(user.getId());
        model.put("articleList", articleList);
        return "dashboard";
    }

}
