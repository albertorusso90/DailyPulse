package com.albertorusso.dailypulse.sources.di

import com.albertorusso.dailypulse.sources.data.SourcesRepositoryImpl
import com.albertorusso.dailypulse.sources.data.SourcesService
import com.albertorusso.dailypulse.sources.domain.SourcesRepository
import com.albertorusso.dailypulse.sources.domain.SourcesUseCase
import com.albertorusso.dailypulse.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {
    single { SourcesService(get()) }
    single { SourcesUseCase(get()) }
    single { SourcesViewModel(get()) }
    single<SourcesRepository> { SourcesRepositoryImpl(get()) }
}