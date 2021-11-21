package com.xxxxx.myblog.controller;

import com.xxxxx.myblog.entity.Article;
import com.xxxxx.myblog.repository.ArticleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.ws.http.HTTPException;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    private ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/")
    public Iterable<Article> findAll() {
        return articleRepository.findAllByOrderByAddedAtDesc();
    }

    @GetMapping("/{slug}")
    public Article findOne(@PathVariable String slug) throws HTTPException {
        Article result = articleRepository.findBySlug(slug);
        if(result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"This article does not found");
        }
        return result;
    }
}
