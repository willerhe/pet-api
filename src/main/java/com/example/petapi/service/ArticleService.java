package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.ArticleMapper;
import com.example.petapi.entity.Article;
import com.example.petapi.entity.ArticleDto;
import com.example.petapi.entity.ArticleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    public Object list(ArticleDto article) {
        ArticleExample e = new ArticleExample();
        ArticleExample.Criteria c = e.createCriteria();
        String unionCode = ",";
        if (article.getKind() != null && article.getKind().equals("汪星人课堂")) {
            unionCode = "、";
        }
        if (article.getTags() != null && !article.getTags().equals("")) {
            c.andTagsLike("%" + article.getTags() + unionCode + "%");
        }

        List<Article> list = articleMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(Article article) {
        article.setId(UUID.randomUUID().toString());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        article.setPublishTime(formatter.format(date));
        articleMapper.insert(article);
        return Result.Success(article);
    }

    public Object update(Article article) {
        return Result.Success(article);
    }

    public Object delete(Article article) {
        articleMapper.deleteByPrimaryKey(article.getId());
        return Result.Success(article);
    }

    public Object medicals(Article article) {
        ArticleExample e = new ArticleExample();
        ArticleExample.Criteria c = e.createCriteria();
        return Result.Success(articleMapper.selectByExample(e));
    }

    public Object getById(Article article) {
        return Result.Success(articleMapper.selectByPrimaryKey(article.getId()));
    }
}
