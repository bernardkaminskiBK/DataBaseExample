package com.example.databaseexample.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.databaseexample.database.entity.MovieShort
import com.example.databaseexample.database.entity.Movie

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertMovie(movie: Movie): Long

    @Insert
    suspend fun insertMovies(movie1: Movie, movie2: Movie)

    @Insert
    suspend fun insertMovies(vararg movie: Movie)

    @Insert
    suspend fun insertMovies(movie: Movie, moreMovies: List<Movie>)

    @Update
    suspend fun updateMovie(movie: Movie): Int

    @Update
    suspend fun updateMovies(movie1: Movie, movie2: Movie): Int

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Delete
    suspend fun deleteMovies(movie1: Movie, movie2: Movie)

    @Query("SELECT * FROM MOVIES")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM MOVIES")
    fun getAllMoviesList(): List<Movie>

    @Query("SELECT movie_name, year FROM movies")
    suspend fun getAllMoviesByNameAndYear(): List<MovieShort>

    @Query("SELECT * FROM MOVIES WHERE YEAR > :year")
    suspend fun getMoviesAfterYear(year: Int): List<Movie>

    @Query("SELECT * FROM MOVIES WHERE YEAR in (:years)")
    suspend fun getMoviesInYears(vararg years: Int): List<Movie>

    @Query("SELECT * FROM MOVIES WHERE YEAR in (:years)")
    suspend fun getMoviesInYears(years: List<Int>): List<Movie>

}