package com.albertorusso.dailypulse.android

import android.app.Application
import com.albertorusso.dailypulse.android.di.databaseModule
import com.albertorusso.dailypulse.android.di.viewModelsModule
import com.albertorusso.dailypulse.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule
        startKoin {
            androidContext(this@DailyPulseApplication)
            modules(modules)
        }
    }
}