package com.albertorusso.dailypulse.android.di

import albertorusso.dailypulse.db.DailyPulseDatabase
import com.albertorusso.dailypulse.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { DatabaseDriverFactory(androidContext()).createDriver() }
    single { DailyPulseDatabase(get()) }
}