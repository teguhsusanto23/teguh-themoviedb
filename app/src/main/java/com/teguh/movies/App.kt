package com.teguh.movies

import android.app.Application
import com.teguh.data.di.ApiModule
import com.teguh.data.di.DataSourceModule
import com.teguh.data.di.RepositoryModule
import com.teguh.domain.di.UseCaseModule
import com.teguh.movies.di.component.ApplicationComponent
import com.teguh.movies.di.component.DaggerApplicationComponent
import com.teguh.movies.di.module.ApplicationModule

class App  : Application()  {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .apiModule(ApiModule())
            .dataSourceModule(DataSourceModule())
            .repositoryModule(RepositoryModule())
            .useCaseModule(UseCaseModule())
            .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }
}