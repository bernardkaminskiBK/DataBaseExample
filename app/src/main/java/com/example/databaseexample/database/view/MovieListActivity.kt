package com.example.databaseexample.database.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databaseexample.MainActivity
import com.example.databaseexample.R
import com.example.databaseexample.database.MyMoviesDatabase
import com.example.databaseexample.database.entity.Movie
import kotlinx.android.synthetic.main.activity_movie_list.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

//        val movies: List<Movie> = listOf(
//            Movie(0L, "First movie", "action, comedy", "Beno benovic", 2020),
//            Movie(0L, "Second movie", "horror", "Alfred Hitchkock", 1976),
//            Movie(0L, "Third movie", "drama", "Beno benovic", 2019)
//        )

        myMoviesRecycler.layoutManager = LinearLayoutManager(this)
       // myMoviesRecycler.adapter = MovieAdapter(movies)

        fab.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        GlobalScope.launch {
            val dao = MyMoviesDatabase.getDataBase(application).movieDAO()
            myMoviesRecycler.adapter = MovieAdapter(dao.getAllMoviesList())
        }
    }
}