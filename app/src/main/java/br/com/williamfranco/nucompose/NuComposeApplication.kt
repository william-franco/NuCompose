package br.com.williamfranco.nucompose

import android.app.Application
import br.com.williamfranco.nucompose.src.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class NuComposeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@NuComposeApplication)
            modules(appModule)
        }
    }
}
