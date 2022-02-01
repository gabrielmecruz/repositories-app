package com.example.portfolioapp

import android.app.Application
import android.app.Presentation
import com.example.portfolioapp.data.di.DataModule
import com.example.portfolioapp.domain.di.DomainModule
import com.example.portfolioapp.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PortfolioApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PortfolioApp)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}