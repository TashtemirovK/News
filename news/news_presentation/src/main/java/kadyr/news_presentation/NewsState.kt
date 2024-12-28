package kadyr.news_presentation

import kadyr.news_domain.model.Article

data class NewsState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Article>? = null,
)
