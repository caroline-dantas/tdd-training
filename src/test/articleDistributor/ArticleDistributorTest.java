package com.dantas.articleDistributor.test;

import com.dantas.articleDistributor.article.Article;
import com.dantas.articleDistributor.article.Type;
import com.dantas.articleDistributor.client.Channel;
import com.dantas.articleDistributor.database.ArticleDataAccess;
import com.dantas.articleDistributor.sender.ArticleDistributor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;

class ArticleDistributorTest {

    @Test
    public void givenAlistOfArticlesAreTheyAreDistributedViaCorrectChannelTest() {
        // Arrange
        // 1. Create Mock Channels
        Channel sport = mock(Channel.class);
        Channel politics = mock(Channel.class);
        Channel finance = mock(Channel.class);
        Channel other = mock(Channel.class);

        // 2. Create Mock for the dataAccess as we don't have its implementation yet
        ArticleDataAccess dataAccess = mock(ArticleDataAccess.class);

        // 3. Create a list of articles we want to distribute
        System.out.println("Given this list is returned from the DB");
        List<Article> articlesList = asList(
                new Article("All major Sports events have been cancelled due to the coronavirus pandemic", Type.SPORT),
                new Article("Prime minister says London won't have a lockdown this weekend", Type.POLITICS),
        new Article("Coronavirus: Biggest world economical crisis ever", Type.FINANCE));

        // 4. Set up the dataAccess mock to return the articles list we created in step 3 whenever we call the method getTodaysArticles
        when(dataAccess.getTodaysArticles()).thenReturn(articlesList);
        System.out.println("When we distribute the articles");
        ArticleDistributor distributor = new ArticleDistributor(sport, politics, other, dataAccess);

        // Act
        // This is want we actually testing: that the article's we created get distributed through the appropriate channels
        distributor.distributeTodaysArticles();

        // Assert
        // Verify the article's we created get distributed through the appropriate channels
        System.out.println("Then they go to their corresponding channels");
        verify(sport).accept(any());
        verify(politics).accept(any());
        verify(other).accept(any());
        verify(finance, never()).accept(any());
    }
}