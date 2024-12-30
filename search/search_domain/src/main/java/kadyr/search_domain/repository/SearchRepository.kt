package kadyr.search_domain.repository

import kadyr.search_domain.model.Article

interface SearchRepository {

    suspend fun getSearchArticles(map: MutableMap<String, String>): List<Article>
}