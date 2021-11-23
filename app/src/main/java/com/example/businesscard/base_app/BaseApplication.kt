package com.example.businesscard.base_app

import android.app.Application
import com.example.businesscard.common.di.commonBusinessCardModule
import com.example.businesscard.feature.add_business_card.di.addBusinessCardModule
import com.example.businesscard.feature.business_card_list.di.businessCardListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    commonBusinessCardModule,
                    businessCardListModule,
                    addBusinessCardModule
                )
            ).androidContext(applicationContext)
        }
    }
}