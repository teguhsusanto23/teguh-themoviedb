package com.teguh.movies.screen.detail

import android.content.Context
import android.content.Intent
import com.teguh.domain.model.movie.MovieItemsModel
import com.teguh.movies.R
import com.teguh.movies.base.BaseActivity
import com.teguh.movies.extentions.fromUrl
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    companion object {
        const val EXTRA_MOVIE = "EXTRA_MOVIE"
        fun newInstance(context: Context, movieItemsModel: MovieItemsModel) : Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE, movieItemsModel)
            return intent
        }
    }
    lateinit var detailMovieItems: MovieItemsModel
    override fun getLayoutResource(): Int = R.layout.activity_detail

    override fun initComponent() {
        activityComponent.inject(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        loadExtra()
        setupView()
    }

    private fun loadExtra(){
        detailMovieItems = intent.getParcelableExtra(EXTRA_MOVIE) as MovieItemsModel
    }

    private fun setupView(){
        detailMovieItems.let {
            title = it.title
            img_poster_detail.fromUrl(it.posterPath)
            txt_rating.text = getString(R.string.rating, it.voteAverage.toString())
            txt_title.text = it.title
            txt_overview.text = it.overview
            txt_release.text = getString(R.string.release_date, it.releaseDate)
        }
    }
}