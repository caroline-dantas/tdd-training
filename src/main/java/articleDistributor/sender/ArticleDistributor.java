package com.dantas.articleDistributor.sender;

import com.dantas.articleDistributor.client.Channel;
import com.dantas.articleDistributor.database.ArticleDataAccess;

import static com.dantas.articleDistributor.article.Type.SPORT;
import static com.dantas.articleDistributor.article.Type.POLITICS;

public class ArticleDistributor {
    private Channel sport;
    private Channel politics;
    private Channel other;
    private ArticleDataAccess dataAccess;

    public ArticleDistributor(Channel sport, Channel politics, Channel other, ArticleDataAccess dataAccess) {
        this.sport = sport;
        this.politics = politics;
        this.other = other;
        this.dataAccess = dataAccess;
    }


    public void distributeTodaysArticles() {
        dataAccess.getTodaysArticles().forEach(article -> {
            switch(article.getType()) {
                case SPORT:
                    sport.accept(article);
                    break;
                case POLITICS:
                    politics.accept(article);
                    break;
                default:
                    other.accept(article);
            }
        });
    }
}
