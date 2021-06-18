package com.teguh.data.di

import com.teguh.data.remote.ApiGenerator
import com.teguh.data.remote.service.ApiMovieService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun providesApiMovieService(): ApiMovieService {
        return ApiGenerator().createApi(ApiMovieService::class.java)
    }
}