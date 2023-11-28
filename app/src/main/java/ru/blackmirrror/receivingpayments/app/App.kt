package ru.blackmirrror.receivingpayments.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.blackmirrror.receivingpayments.app.di.appModule
import ru.blackmirrror.receivingpayments.app.di.dataModule
import ru.blackmirrror.receivingpayments.app.di.domainModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule, dataModule, domainModule)
        }
    }
}