package com.rockink.daggerpoc

import android.app.Application
import com.rockink.daggerpoc.daggerComponents.DaggerAppComponent

class MyApp : Application() {

    override fun onCreate() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        

        super.onCreate()
    }
}