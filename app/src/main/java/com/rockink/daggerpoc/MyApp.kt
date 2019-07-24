package com.rockink.daggerpoc

import android.app.Application
import android.widget.Toast
import com.rockink.daggerpoc.application.RandomStringer
import com.rockink.daggerpoc.daggerComponents.DaggerAppComponent
import javax.inject.Inject

class MyApp : Application() {

    @Inject lateinit var randomStringer: RandomStringer

    override fun onCreate() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        super.onCreate()
        Toast.makeText(this, randomStringer.getRandomString(), Toast.LENGTH_SHORT).show()
    }
}