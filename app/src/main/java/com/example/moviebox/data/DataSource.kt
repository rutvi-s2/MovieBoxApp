package com.example.moviebox.data

import com.example.moviebox.R
import com.example.moviebox.model.Movie

/**
 * An object to generate a static list of bunnies
 */
object DataSource {

    val movies: MutableList<Movie> = mutableListOf(
        Movie(
            R.drawable.luca,
            "Roger",
            "GREAT MOVIE",
            4
        ),
        Movie(
            R.drawable.luca,
            "Fuzzy",
            "AWFUL MOVIE",
            1
        )
    )
}
