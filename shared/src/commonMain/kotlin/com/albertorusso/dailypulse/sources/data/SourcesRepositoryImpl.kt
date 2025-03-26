package com.albertorusso.dailypulse.sources.data

import com.albertorusso.dailypulse.sources.domain.SourcesRepository
import com.albertorusso.dailypulse.sources.domain.Source

class SourcesRepositoryImpl(
    private val sourcesService: SourcesService
): SourcesRepository {

    override suspend fun getSources(): List<Source> {
        val sources = sourcesService.fetchSources()
        return sources.map { sourceRaw ->
            Source(
                name = sourceRaw.name,
                description =  sourceRaw.description,
                country = sourceRaw.country,
                language = sourceRaw.language
            )
        }
    }
}