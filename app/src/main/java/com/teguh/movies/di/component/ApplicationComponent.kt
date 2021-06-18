package com.teguh.movies.di.component

import com.teguh.data.di.ApiModule
import com.teguh.data.di.DataSourceModule
import com.teguh.data.di.RepositoryModule
import com.teguh.domain.di.UseCaseModule
import com.teguh.domain.usecase.movie.MoviesUseCase
import com.teguh.movies.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        ApiModule::class,
        DataSourceModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface ApplicationComponent {

    fun moviesUseCase() : MoviesUseCase
}