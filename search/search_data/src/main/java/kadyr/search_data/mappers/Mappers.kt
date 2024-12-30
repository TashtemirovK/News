package kadyr.search_data.mappers

import kadyr.search_data.model.ArticleDTO
import kadyr.search_domain.model.Article

fun ArticleDTO.toDomainArticle(): Article {
    return Article(
        author = this.author ?: "",
        content = this.content ?: "",
        description = this.description ?: "",
        title = this.title ?: "",
        urlToImage = this.urlToImage ?: "",
    )
}