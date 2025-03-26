package com.albertorusso.dailypulse.di

import com.albertorusso.dailypulse.articles.di.articlesModule
import com.albertorusso.dailypulse.sources.di.sourcesModule

val sharedKoinModules = listOf(
    articlesModule,
    sourcesModule,
    networkModule
)