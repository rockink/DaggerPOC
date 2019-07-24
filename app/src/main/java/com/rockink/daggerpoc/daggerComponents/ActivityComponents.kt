package com.rockink.daggerpoc.daggerComponents

import com.rockink.daggerpoc.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Subcomponent
interface MainActivitySubComponent: AndroidInjector<MainActivity>{
    @Subcomponent.Factory
    interface Factory: AndroidInjector.Factory<MainActivity>{}
}


@Module(subcomponents = [MainActivitySubComponent::class])
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindAndroidInjectorFactory(factory: MainActivitySubComponent.Factory): AndroidInjector.Factory<*>
}