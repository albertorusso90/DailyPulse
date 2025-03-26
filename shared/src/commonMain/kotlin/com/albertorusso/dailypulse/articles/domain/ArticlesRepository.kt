package com.albertorusso.dailypulse.articles.domain

interface ArticlesRepository {
    suspend fun getArticles(forceFetch: Boolean): List<Article>
}