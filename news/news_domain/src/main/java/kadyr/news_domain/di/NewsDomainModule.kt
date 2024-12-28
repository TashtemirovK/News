package kadyr.news_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kadyr.news_domain.repository.NewsRepository
import kadyr.news_domain.use_case.GetNewsArticleUseCase

@InstallIn(SingletonComponent::class)
@Module
object NewsDomainModule {

    @Provides
    fun provideGetNewsUsaCase(newsRepository: NewsRepository): GetNewsArticleUseCase{
        return GetNewsArticleUseCase(newsRepository)
    }
}