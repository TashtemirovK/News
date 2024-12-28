package kadyr.news_domain.repository

import kadyr.news_domain.model.Article

interface NewsRepository {

    suspend fun getNewsArticle(): List<Article>
}