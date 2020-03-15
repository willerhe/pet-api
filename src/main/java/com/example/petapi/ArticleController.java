package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import com.example.petapi.entity.Article;
import com.example.petapi.entity.ArticleDto;
import com.example.petapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/v1/articles")
    public JSONObject list(ArticleDto article) {
        return Result.Success(articleService.list(article));
    }

    @GetMapping("/v1/article")
    public JSONObject getById(Article article) {
        return Result.Success(articleService.getById(article));
    }

    @GetMapping("/v1/article/medicals")
    public JSONObject medicals(Article article) {
        return Result.Success(articleService.medicals(article));
    }


    @PostMapping("/v1/article")
    public JSONObject insert(@RequestBody  Article article) {
        return Result.Success(articleService.insert(article));
    }


    @PutMapping("/v1/article")
    public JSONObject update(Article article) {
        return Result.Success(articleService.update(article));
    }

    @DeleteMapping("/v1/article")
    public JSONObject delete(Article article) {
        return Result.Success(articleService.delete(article));
    }


}
