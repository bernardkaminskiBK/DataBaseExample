package com.example.databaseexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.databaseexample.databinding.ActivityMainBinding
import com.example.databaseexample.database.MyMoviesDatabase
import com.example.databaseexample.database.entity.Movie
import com.example.databaseexample.database.view.MovieListActivity
import kotlinx.android.synthetic.main.activity_main.*

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

        floatingActionButton.setOnClickListener {
            viewModel.addMovie()
            startActivity(Intent(this, MovieListActivity::class.java))
        }
    }
}