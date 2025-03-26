package com.albertorusso.dailypulse.articles.data

import com.albertorusso.dailypulse.articles.domain.Article
import com.albertorusso.dailypulse.articles.domain.ArticlesRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesRepositoryImpl(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
): ArticlesRepository {
    override suspend fun getArticles(forceFetch: Boolean): List<Article> {
        if(forceFetch) {
            dataSource.clearArticles()
            return mapArticles(fetchedArticles())
        }

        val articlesDb = dataSource.getAllArticles()

        if(articlesDb.isEmpty()) {
            return mapArticles(fetchedArticles())
        }

        return mapArticles(articlesDb)
    }

    private suspend fun fetchedArticles(): List<ArticleRaw> {
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map { raw ->
        Article(
            title = raw.title,
            description = raw.desc ?: "Click to find out more",
            date = getDaysAgoString(raw.date),
            imageUrl = raw.imageUrl ?: "https://media.licdn.com/dms/image/v2/D4E03AQF1e_POyJVFPg/profile-displayphoto-shrink_200_200/profile-displayphoto-shrink_200_200/0/1694198007084?e=1747872000&v=beta&t=99BjheI9HYrK-YLnxVPiNyupIM92tzxw8DCpfKVGyD8"
        )
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }

}