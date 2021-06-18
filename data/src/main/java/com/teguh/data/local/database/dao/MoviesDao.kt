package com.teguh.data.local.database.dao

import androidx.room.*
import com.teguh.data.local.entity.movie.MovieEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface MoviesDao {

    @Query("SELECT * FROM table_movies")
    fun getAll(): Flowable<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: MovieEntity): Completable

    @Delete
    fun delete(entity: MovieEntity)
}