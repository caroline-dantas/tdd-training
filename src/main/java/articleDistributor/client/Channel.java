package com.dantas.articleDistributor.client;

import com.dantas.articleDistributor.article.Article;

public interface Channel {

    void accept(Article article);
}
