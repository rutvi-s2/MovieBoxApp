package com.example.moviebox.data

import com.example.moviebox.R
import com.example.moviebox.model.Movie

/**
 * An object to generate a static list of bunnies
 */
object DataSource {

    val movies: List<Movie> = listOf(
        Movie(
            R.drawable.luca,
            "Roger"
        ),
        Movie(
            R.drawable.luca,
            "Fuzzy"
        )
    )
}