package com.dantas.articleDistributor.database;

import com.dantas.articleDistributor.article.Article;

import java.util.List;

public interface ArticleDataAccess {
    List<Article> getTodaysArticles();
}
