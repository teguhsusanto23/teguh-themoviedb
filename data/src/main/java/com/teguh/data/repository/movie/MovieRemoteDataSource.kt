package com.teguh.data.repository.movie

import com.teguh.data.local.entity.movie.MovieEntity
import com.teguh.data.remote.model.movies.MoviesResponse
import com.teguh.data.remote.service.ApiMovieService
import com.teguh.data.utils.Const
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

class MovieRemoteDataSource (
    private val apiService: ApiMovieService
) : RepositoryMovieDataSource {

    override fun getMoviePopular(
        page : Int
    ): Observable<MoviesResponse> {
        return apiService.getMoviePopular(page = page)
    }

    override fun getMovieUpComing(
        page : Int
    ): Observable<MoviesResponse> {
        return apiService.getMovieUpComing(page = page)
    }

    override fun getMovieNowPlaying(
        page : Int
    ): Observable<MoviesResponse> {
        return apiService.getMovieNowPlaying(page = page)
    }

    override fun saveMovie(entity: MovieEntity): Completable {
        throw IllegalArgumentException(Const.NOT_IMPLEMENT_REMOTE_DATASOURCE)
    }

    override fun getMovieFavorite(): Flowable<List<MovieEntity>> {
        throw IllegalArgumentException(Const.NOT_IMPLEMENT_REMOTE_DATASOURCE)
    }


}