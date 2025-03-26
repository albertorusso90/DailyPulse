package com.albertorusso.dailypulse.sources.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(private val httpClient: HttpClient) {

    private val apiKey = "1b0b2383605645d885bf2f8530dd1f5f"

    suspend fun fetchSources(): List<SourceDto> {
        val response: SourcesResponse = httpClient.get("https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey").body()
        return response.sources
    }
}