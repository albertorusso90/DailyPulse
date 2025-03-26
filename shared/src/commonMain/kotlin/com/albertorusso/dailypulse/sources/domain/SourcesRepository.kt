package com.albertorusso.dailypulse.sources.domain

interface SourcesRepository {
    suspend fun getSources(): List<Source>
}