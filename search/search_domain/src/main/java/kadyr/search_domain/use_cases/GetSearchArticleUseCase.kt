package kadyr.search_domain.use_cases

import kadyr.common_utils.Resource
import kadyr.search_domain.model.Article
import kadyr.search_domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSearchArticleUseCase(private val searchRepository: SearchRepository) {

    operator fun invoke(map: MutableMap<String, String>): Flow<Resource<List<Article>>> = flow {

        emit(Resource.Loading())
        try {
            emit(Resource.Success(searchRepository.getSearchArticles(map)))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}