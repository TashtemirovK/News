package kadyr.search_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kadyr.search_domain.repository.SearchRepository
import kadyr.search_domain.use_cases.GetSearchArticleUseCase

@InstallIn(SingletonComponent::class)
@Module
object SearDomainModule {

    @Provides
    fun provideSearchUseCase(searchRepository: SearchRepository): GetSearchArticleUseCase {
        return GetSearchArticleUseCase(searchRepository)
    }
}