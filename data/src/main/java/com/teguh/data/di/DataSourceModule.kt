package com.teguh.data.di

import android.content.Context
import androidx.room.Room
import com.teguh.data.local.database.DatabaseStorage
import com.teguh.data.remote.service.ApiMovieService
import com.teguh.data.repository.movie.MovieLocalDataSource
import com.teguh.data.repository.movie.MovieRemoteDataSource
import com.teguh.data.repository.movie.RepositoryMovieDataSource
import com.teguh.data.utils.Const
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataSourceModule {


    @Provides
    @Singleton
    fun provideDatabaseStorage(context: Context): DatabaseStorage {
        return Room.databaseBuilder(context,
            DatabaseStorage::class.java, "Catalogue.db")
            .build()
    }

    /*DATA SOURCE MOVIE*/
    @Provides
    @Singleton
    @Named(Const.LOCAL_DATASOURCE)
    fun provideMovieLocalDataSource(database: DatabaseStorage): RepositoryMovieDataSource {
        return MovieLocalDataSource(database)
    }

    @Provides
    @Singleton
    @Named(Const.REMOTE_DATASOURCE)
    fun provideMovieRemoteDataSource(apiService: ApiMovieService): RepositoryMovieDataSource {
        return MovieRemoteDataSource(apiService)
    }

}