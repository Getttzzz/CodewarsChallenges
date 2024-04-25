package com.codewars.codewarschallenges

import android.app.Application
import com.codewars.codewarschallenges.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CodewarsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CodewarsApp)
            modules(appComponent)
        }
    }
}
