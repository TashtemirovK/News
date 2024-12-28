package kadyr.news_data.mapper

import kadyr.news_data.model.ArticleDTO
import kadyr.news_domain.model.Article

fun ArticleDTO.toDomainArticle(): Article {
    return Article(
        author = this.author,
        content = this.content,
        description = this.description,
        title = this.title,
        urlToImage = this.urlToImage,
    )
}