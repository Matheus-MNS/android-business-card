package com.example.businesscard.common.di

import com.example.businesscard.common.data.local.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val commonBusinessCardModule = module {

    factory {
        AppDatabase.getDatabase(
            context = androidApplication()
        ).businessDao()
    }
}