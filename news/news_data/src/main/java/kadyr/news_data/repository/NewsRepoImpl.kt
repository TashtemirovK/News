package kadyr.news_data.repository

import kadyr.news_data.mapper.toDomainArticle
import kadyr.news_data.network.NewsApiService
import kadyr.news_domain.model.Article
import kadyr.news_domain.repository.NewsRepository

class NewsRepoImpl(private val newsApiService: NewsApiService) : NewsRepository {
    override suspend fun getNewsArticle(): List<Article> {
        return newsApiService.getNewsArticles(country = "us").articles.map { it.toDomainArticle() }
    }

}