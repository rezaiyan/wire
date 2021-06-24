package io.github.rezaiyan.wire.android

import android.app.Application
import io.github.rezaiyan.wire.common.main.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent

class App : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            // androidLogger()
            androidContext(this@App)
            modules(appModule)
        }

    }
}