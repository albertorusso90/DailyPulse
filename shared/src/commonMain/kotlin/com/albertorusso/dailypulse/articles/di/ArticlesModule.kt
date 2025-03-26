package com.albertorusso.dailypulse.articles.di

import com.albertorusso.dailypulse.articles.data.ArticlesDataSource
import com.albertorusso.dailypulse.articles.data.ArticlesRepositoryImpl
import com.albertorusso.dailypulse.articles.data.ArticlesService
import com.albertorusso.dailypulse.articles.domain.ArticlesRepository
import com.albertorusso.dailypulse.articles.domain.ArticlesUseCase
import com.albertorusso.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single { ArticlesService(get()) }
    single { ArticlesUseCase(get()) }
    single { ArticlesViewModel(get()) }
    single { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepositoryImpl(get(), get()) }
}