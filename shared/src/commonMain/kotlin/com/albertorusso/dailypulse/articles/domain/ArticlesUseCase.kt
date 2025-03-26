package com.albertorusso.dailypulse.articles.domain

class ArticlesUseCase(private val articlesRepository: ArticlesRepository) {

    suspend fun getArticles(forceFetch: Boolean): List<Article> {
        val articles = articlesRepository.getArticles(forceFetch = forceFetch)
        return articles
    }
}