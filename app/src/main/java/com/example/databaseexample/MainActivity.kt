package com.example.databaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.databaseexample.databinding.ActivityMainBinding
import database.MyMoviesDatabase
import database.entity.Movie

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = MyMoviesDatabase.getDataBase(application).movieDAO()

        val factory = MainViewModelFactory(dao)

        val viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.allMovies.observe(this, { movies: List<Movie> ->
            binding.allMoviesTextView.text = movies.toString()
        })

    }
}