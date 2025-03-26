package com.albertorusso.dailypulse.articles.presentation

import com.albertorusso.dailypulse.articles.domain.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
