package com.teguh.domain.di

import com.teguh.domain.repository.MovieDomainRepository
import com.teguh.domain.usecase.movie.MoviesUseCase
import com.teguh.domain.usecase.movie.MoviesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesMovieUseCase(repository: MovieDomainRepository) : MoviesUseCase {
        return MoviesUseCaseImpl(repository)
    }

}