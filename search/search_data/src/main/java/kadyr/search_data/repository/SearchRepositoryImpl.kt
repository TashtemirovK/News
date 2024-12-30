package kadyr.search_data.repository

import kadyr.search_data.mappers.toDomainArticle
import kadyr.search_data.network.SearchApi
import kadyr.search_domain.model.Article
import kadyr.search_domain.repository.SearchRepository

class SearchRepositoryImpl(private val searchApi: SearchApi) : SearchRepository {

    override suspend fun getSearchArticles(map: MutableMap<String, String>): List<Article> {
        return searchApi.getSearchArticles(map).articles.map { it.toDomainArticle() }
    }
}