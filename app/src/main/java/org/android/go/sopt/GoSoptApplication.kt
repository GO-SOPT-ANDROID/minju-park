package org.android.go.sopt

import android.app.Application
import timber.log.Timber

class GoSoptApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
