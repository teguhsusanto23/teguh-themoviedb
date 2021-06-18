package com.teguh.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.teguh.data.local.database.dao.MoviesDao
import com.teguh.data.local.entity.movie.MovieEntity

@Database(entities = [
    MovieEntity::class],
    version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DatabaseStorage : RoomDatabase() {

    abstract fun movieDao() : MoviesDao

}