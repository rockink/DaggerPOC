package com.rockink.daggerpoc.daggerComponents

import android.content.Context
import android.content.SharedPreferences
import com.rockink.daggerpoc.MyApp
import com.rockink.daggerpoc.application.RandomStringer
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Inject
import javax.inject.Singleton

@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    MainActivityModule::class
])
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
class AppModule {


    @Provides
    @Singleton
    fun provideContext(app: MyApp): Context = app;

    @Provides
    @Singleton
    fun provideRandomStringer(): RandomStringer {
        return RandomStringer();
    }

    @Provides
    @Singleton
    fun provideSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences("DEFAULT", Context.MODE_PRIVATE);
    }
}