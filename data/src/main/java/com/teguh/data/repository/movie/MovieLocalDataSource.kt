package com.teguh.data.repository.movie

import com.teguh.data.local.database.DatabaseStorage
import com.teguh.data.local.entity.movie.MovieEntity
import com.teguh.data.remote.model.movies.MoviesResponse
import com.teguh.data.utils.Const
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

class MovieLocalDataSource  (
    private val databaseStorage: DatabaseStorage
) : RepositoryMovieDataSource {

    override fun getMoviePopular(
        page : Int
    ): Observable<MoviesResponse> {
        throw IllegalArgumentException(Const.NOT_IMPLEMENT_LOCAL_DATASOURCE)
    }

    override fun getMovieUpComing(
        page : Int
    ): Observable<MoviesResponse> {
        throw IllegalArgumentException(Const.NOT_IMPLEMENT_LOCAL_DATASOURCE)
    }

    override fun getMovieNowPlaying(
        page : Int
    ): Observable<MoviesResponse> {
        throw IllegalArgumentException(Const.NOT_IMPLEMENT_LOCAL_DATASOURCE)
    }

    override fun saveMovie(entity: MovieEntity): Completable =
        databaseStorage.movieDao().insert(entity)

    override fun getMovieFavorite(): Flowable<List<MovieEntity>> =
        databaseStorage.movieDao().getAll()
}