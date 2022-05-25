package com.andrey.notion

import android.app.Application
import com.andrey.notion.dagger.ApplicationComponent
import com.andrey.notion.dagger.DaggerApplicationComponent
import timber.log.Timber

class MainApplication: Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()

        Timber.d(appComponent.toString())
    }

}