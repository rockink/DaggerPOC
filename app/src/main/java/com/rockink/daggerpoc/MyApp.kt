package com.rockink.daggerpoc

import android.app.Application
import android.widget.Toast
import com.rockink.daggerpoc.application.RandomStringer
import com.rockink.daggerpoc.daggerComponents.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApp : Application(), HasAndroidInjector {

    @Inject lateinit var randomStringer: RandomStringer
    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector;
    }


    override fun onCreate() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        super.onCreate()
        Toast.makeText(this, randomStringer.getRandomString(), Toast.LENGTH_SHORT).show()
    }
}