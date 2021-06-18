package com.teguh.data.remote.service

import com.teguh.data.BuildConfig
import com.teguh.data.remote.model.movies.MovieItems
import com.teguh.data.remote.model.movies.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiMovieService {

    @GET("movie/{movie_id}")
    fun getDetailMovie (@Path("movie_id") id : Int)
            : Observable<MovieItems>

    @GET("movie/popular")
    fun getMoviePopular (
        @Query("api_key") key : String = BuildConfig.API_KEY,
        @Query("page") page : Int
    ) : Observable<MoviesResponse>

    @GET("movie/upcoming")
    fun getMovieUpComing (
        @Query("api_key") key : String = BuildConfig.API_KEY,
        @Query("page") page : Int
    ) : Observable<MoviesResponse>

    @GET("movie/now_playing")
    fun getMovieNowPlaying (
        @Query("api_key") key : String = BuildConfig.API_KEY,
        @Query("page") page : Int
    ) : Observable<MoviesResponse>


}