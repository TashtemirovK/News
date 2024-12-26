package kadyr.news.navigation

import kadyr.common_utils.Activities
import kadyr.common_utils.Navigator
import kadyr.news_presentation.GoToNewsActivity
import kadyr.search_presentation.SearchActivity


class DefaultNavigator : Navigator.Provider {

    override fun getActivities(activities: Activities): Navigator {
        return when (activities) {
            Activities.NewsActivity -> {
                GoToNewsActivity
            }

            Activities.SearchActivity -> {
                SearchActivity.GoToSearchActivity
            }
        }
    }
}

