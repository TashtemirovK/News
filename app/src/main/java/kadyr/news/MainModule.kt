package kadyr.news

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kadyr.common_utils.Navigator
import kadyr.news.navigation.DefaultNavigator
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MainModule {

    @Provides
    @Singleton
    fun provideProvider(): Navigator.Provider {
        return DefaultNavigator()
    }
}