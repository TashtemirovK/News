package kadyr.search_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kadyr.search_data.network.SearchApi
import kadyr.search_data.repository.SearchRepositoryImpl
import kadyr.search_domain.repository.SearchRepository
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object SearchModule {

    @Provides
    fun searchApi(retrofit: Retrofit): SearchApi {
        return retrofit.create(SearchApi::class.java)
    }

    @Provides
    fun searchRepo(searchApi: SearchApi): SearchRepository {
        return SearchRepositoryImpl(searchApi)
    }
}