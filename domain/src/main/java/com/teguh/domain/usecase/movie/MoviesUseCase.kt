package com.teguh.domain.usecase.movie

import com.teguh.domain.model.movie.MovieItemsModel
import com.teguh.domain.model.movie.MoviesResponseModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

interface MoviesUseCase {

    fun getMoviePopular(
        page : Int
    ): Observable<MoviesResponseModel>

    fun getMovieUpComing(
        page : Int
    ): Observable<MoviesResponseModel>

    fun getMovieNowPlaying(
        page : Int
    ): Observable<MoviesResponseModel>

    fun saveMovie(entity : MovieItemsModel) : Completable

    fun getMovieFavorite() : Flowable<List<MovieItemsModel>>

}