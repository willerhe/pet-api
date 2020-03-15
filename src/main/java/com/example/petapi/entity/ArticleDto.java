package com.example.petapi.entity;

public class ArticleDto extends Article {
    private String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
