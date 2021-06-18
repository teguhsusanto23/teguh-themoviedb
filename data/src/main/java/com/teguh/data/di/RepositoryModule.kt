package com.teguh.data.di

import com.teguh.data.repository.movie.RepositoryMovieDataSource
import com.teguh.data.repository.movie.RepositoryMovieImpl
import com.teguh.data.utils.Const
import com.teguh.domain.repository.MovieDomainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        @Named(Const.LOCAL_DATASOURCE) localDataSource: RepositoryMovieDataSource,
        @Named(Const.REMOTE_DATASOURCE) remoteDataSource: RepositoryMovieDataSource
    ): MovieDomainRepository {
        return RepositoryMovieImpl(localDataSource, remoteDataSource)
    }

}