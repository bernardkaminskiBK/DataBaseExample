package com.example.databaseexample.database.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseexample.R
import com.example.databaseexample.database.entity.Movie

class MovieAdapter(val movieList: List<Movie>): RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_row, parent, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList.get(position)
        holder.setMovieData(movie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}