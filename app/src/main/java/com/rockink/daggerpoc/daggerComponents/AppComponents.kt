package com.rockink.daggerpoc.daggerComponents

import com.rockink.daggerpoc.MyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [AndroidInjectionModule::class])
interface AppComponent {
    fun inject(app: MyApp)

    /**
     * This Builder will be constructed by Dagger
     * @BindsInstance binds the current instance into the DI graph,
     * It means that we can use this instance anywhere in our DI graph
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApp): Builder
        fun build(): AppComponent
    }
}