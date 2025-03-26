package com.albertorusso.dailypulse.sources.domain

class SourcesUseCase(private val sourcesRepository: SourcesRepository) {
    suspend fun getSources(): List<Source> {
        return sourcesRepository.getSources()
    }
}