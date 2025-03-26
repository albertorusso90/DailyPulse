package com.albertorusso.dailypulse.android.di

import com.albertorusso.dailypulse.articles.presentation.ArticlesViewModel
import com.albertorusso.dailypulse.sources.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { ArticlesViewModel(get()) }
    viewModel { SourcesViewModel(get()) }
}