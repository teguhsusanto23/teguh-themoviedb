package com.teguh.movies.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.teguh.domain.model.movie.MovieItemsModel
import com.teguh.domain.usecase.movie.MoviesUseCase
import com.teguh.movies.data.NetworkState
import com.teguh.movies.data.TypeMovie
import io.reactivex.disposables.CompositeDisposable

class MoviePagedListRepository (private val moviesUseCase: MoviesUseCase) {

    private lateinit var movieDataSourceFactory: MovieDataSourceFactory
    private var PAGE_SIZE = 10

    fun fetchingMovieList(
        compositeDisposable: CompositeDisposable,
        typeMovie: TypeMovie
    ) : LiveData<PagedList<MovieItemsModel>> {
        movieDataSourceFactory = MovieDataSourceFactory(moviesUseCase, compositeDisposable, typeMovie)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setPageSize(PAGE_SIZE)
            .build()

        return LivePagedListBuilder(movieDataSourceFactory, config).build()
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap(
            movieDataSourceFactory.movieDataSourceLiveData, MovieDataSource::networkState
        )
    }
}