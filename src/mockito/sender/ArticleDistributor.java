package mockito.sender;

import mockito.client.Channel;
import mockito.database.ArticleDataAccess;

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
