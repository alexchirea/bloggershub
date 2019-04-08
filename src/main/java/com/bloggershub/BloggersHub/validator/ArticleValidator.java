package com.bloggershub.BloggersHub.validator;

import com.bloggershub.BloggersHub.model.Article;
import com.bloggershub.BloggersHub.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ArticleValidator implements Validator {
    @Autowired
    private ArticleService articleService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Article.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Article article = (Article) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "NotEmpty");
        if (article.getContent().length() < 1) {
            errors.rejectValue("content", "Size.articleForm.content");
        }
    }
}