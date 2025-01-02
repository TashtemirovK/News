package kadyr.search_presentation

import kadyr.search_domain.model.Article

data class SearchState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Article>? = null,
)
