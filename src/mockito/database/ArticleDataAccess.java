package mockito.database;

import mockito.article.Article;

import java.util.List;

public interface ArticleDataAccess {
    List<Article> getTodaysArticles();
}
