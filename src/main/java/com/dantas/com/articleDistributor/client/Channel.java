package com.dantas.com.articleDistributor.client;

import com.dantas.com.articleDistributor.article.Article;

public interface Channel {

    void accept(Article article);
}
