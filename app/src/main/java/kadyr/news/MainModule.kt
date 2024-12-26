package kadyr.news

import kadyr.common_utils.Navigator
import kadyr.news.navigation.DefaultNavigator

//@InstallIn(SingletonComponent::class)
//@Module
object MainModule {

//    @Provides
//    @Singleton
    fun provideProvider(): Navigator.Provider {
        return DefaultNavigator()
    }
}