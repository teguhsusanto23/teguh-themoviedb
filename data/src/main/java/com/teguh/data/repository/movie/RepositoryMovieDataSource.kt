package com.teguh.data.repository.movie

import com.teguh.data.local.entity.movie.MovieEntity
import com.teguh.data.remote.model.movies.MoviesResponse
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

interface RepositoryMovieDataSource {

    fun getMoviePopular(
        page : Int
    ): Observable<MoviesResponse>

    fun getMovieUpComing(
        page : Int
    ): Observable<MoviesResponse>

    fun getMovieNowPlaying(
        page : Int
    ): Observable<MoviesResponse>

    fun saveMovie(entity : MovieEntity) : Completable

    fun getMovieFavorite() : Flowable<List<MovieEntity>>

}