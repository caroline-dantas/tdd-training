package com.dantas.com.articleDistributor.database;

import com.dantas.com.articleDistributor.article.Article;

import java.util.List;

public interface ArticleDataAccess {
    List<Article> getTodaysArticles();
}
