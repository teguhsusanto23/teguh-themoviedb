package com.teguh.movies.data.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.teguh.domain.model.movie.MovieItemsModel
import com.teguh.domain.usecase.movie.MoviesUseCase
import com.teguh.movies.data.TypeMovie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory(
    private val moviesUseCase: MoviesUseCase,
    private val compositeDisposable: CompositeDisposable,
    private val typeMovie: TypeMovie
) : DataSource.Factory<Int, MovieItemsModel>() {

    val movieDataSourceLiveData = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, MovieItemsModel> {
        val movieDataSource = MovieDataSource(moviesUseCase, compositeDisposable, typeMovie)
        movieDataSourceLiveData.postValue(movieDataSource)
        return movieDataSource
    }
}