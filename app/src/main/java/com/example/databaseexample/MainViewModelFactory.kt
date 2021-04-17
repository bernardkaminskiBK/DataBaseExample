package com.example.databaseexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import database.dao.MovieDAO

class MainViewModelFactory(private val dataSource: MovieDAO): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(MainViewModel::class.java)){
           return MainViewModel(dataSource) as T
       }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}