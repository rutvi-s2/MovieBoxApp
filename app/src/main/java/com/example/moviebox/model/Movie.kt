package com.example.moviebox.model
import android.graphics.Bitmap
import androidx.annotation.DrawableRes

/**
 * A data class to represent the information presented in the movie card
 */
data class Movie(
    val imageResourceBitmap: Bitmap,
    val name: String,
    val review: String,
    val rating: Int
)