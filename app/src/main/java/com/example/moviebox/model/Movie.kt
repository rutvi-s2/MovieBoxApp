package com.example.moviebox.model
import androidx.annotation.DrawableRes

/**
 * A data class to represent the information presented in the movie card
 */
data class Movie(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val review: String,
    val rating: Int

)