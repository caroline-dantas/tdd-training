package com.dantas.com.articleDistributor.article;

public class Article {
    private String content;
    private Type type;

    public Article(String content, Type type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return this.content;
    }

    public Type getType() {
        return this.type;
    }
}
