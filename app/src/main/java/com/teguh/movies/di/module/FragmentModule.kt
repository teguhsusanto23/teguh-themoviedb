package com.teguh.movies.di.module

import com.teguh.domain.usecase.movie.MoviesUseCase
import com.teguh.movies.data.source.MoviePagedListRepository
import dagger.Module
import dagger.Provides


@Module
class FragmentModule {

    @Provides
    fun providePagedListRepository(moviesUseCase: MoviesUseCase) =
        MoviePagedListRepository(moviesUseCase)
}