package com.rockink.daggerpoc.daggerComponents

import com.rockink.daggerpoc.MyApp
import com.rockink.daggerpoc.application.RandomStringer
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class, AppModule::class])
@Singleton
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

@Module
class AppModule(){

    @Provides
    @Singleton
    fun provideRandomStringer(): RandomStringer {
        return RandomStringer();
    }
}