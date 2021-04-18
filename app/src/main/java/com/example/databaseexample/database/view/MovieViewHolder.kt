package com.example.databaseexample.database.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseexample.R
import com.example.databaseexample.database.entity.Movie

class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var movieYear: TextView?
    private var movieDirectors: TextView?
    private var movieName: TextView?
    private var movieImage: ImageView?

    init {
        movieYear = view.findViewById(R.id.yearTextView)
        movieDirectors = view.findViewById(R.id.movieDirectorsTextView)
        movieName = view.findViewById(R.id.movieNameTextView)
        movieImage = view.findViewById(R.id.imageView)
    }

    fun setMovieData(movie: Movie){
        movieYear?.setText(movie.year.toString())
        movieDirectors?.setText(movie.directors)
        movieName?.setText(movie.name)
    }

}