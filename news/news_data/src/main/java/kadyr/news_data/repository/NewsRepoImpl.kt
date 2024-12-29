package kadyr.news_data.repository

import kadyr.news_data.mapper.toDomainArticle
import kadyr.news_data.network.NewsApiService
import kadyr.news_data.room.NewsDAO
import kadyr.news_domain.model.Article
import kadyr.news_domain.repository.NewsRepository

class NewsRepoImpl(private val newsApiService: NewsApiService, private val newsDAO: NewsDAO) :
    NewsRepository {
    override suspend fun getNewsArticle(): List<Article> {
        try {
            val temp =
                newsApiService.getNewsArticles(country = "us").articles.map { it.toDomainArticle() }
            newsDAO.insertList(temp)
            return newsDAO.getNewsArticle()
        } catch (e: Exception) {
            return newsDAO.getNewsArticle()
        }
    }
}