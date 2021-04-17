package com.example.databaseexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import database.dao.MovieDAO
import database.entity.Movie
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val movieDAO: MovieDAO) : ViewModel() {

//    private var _name = MutableLiveData<String>()
//    private var _genres = MutableLiveData<String>()
//    private var _directors = MutableLiveData<String>()
//    private var _year = MutableLiveData<Int>()
//
//    val name: LiveData<String>
//        get() = _name
//    val genres: LiveData<String>
//        get() = _genres
//    val directors: LiveData<String>
//        get() = _directors
//    val year: LiveData<Int>
//        get() = _year
//
//    fun addMovie() {
//       movieDAO.insertMovie(Movie(0L, _name.value!!, _genres.value!!,_directors.value!!, _year.value!!))
//    }

    private var _movie = MutableLiveData<Movie>(Movie())
    val movie: LiveData<Movie>
        get() = _movie

    val allMovies: LiveData<List<Movie>> = movieDAO.getAllMovies()

    fun addMovie() {
        GlobalScope.launch {
            _movie.value?.let { movieDAO.insertMovie(it) }
        }
    }

}