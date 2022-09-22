package com.example.moviebox.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviebox.R
import com.example.moviebox.data.DataSource
import com.example.moviebox.databinding.ActivityMainBinding
import com.example.moviebox.model.Movie

class FullScreenMovieAdapter(
    private val context: Context
): RecyclerView.Adapter<FullScreenMovieAdapter.FullScreenMovieViewHolder>() {

    // initialize the data using the movie List found in DataSource
    private var movies: List<Movie> = DataSource.movies
    /**
     * Initialize view elements
     */
    class FullScreenMovieViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // declare and initialize all of the bunny list item UI components
        val movieImageView: ImageView = view!!.findViewById(R.id.full_screen_movie_image)
        val movieNameTextView: TextView = view!!.findViewById(R.id.full_screen_movie_name)
        val movieReviewTextView: TextView = view!!.findViewById(R.id.full_screen_movie_review)
        val movieRatingTextView: TextView = view!!.findViewById(R.id.full_screen_movie_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FullScreenMovieViewHolder {
        // determine which list item should be used and set layout accordingly
        // grid vs vertical/horizontal

        var adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.full_screen_movie_item, parent, false)
        // inflate layout and return
        return FullScreenMovieViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        // return size of movies data set
        return movies.size
    }

    override fun onBindViewHolder(holder: FullScreenMovieViewHolder, position: Int) {
        // set the resource for the current bunny
        val resources = context?.resources
        // get the data at the current position
        val movie = movies[position]
        holder.movieImageView.setImageBitmap(movie.imageResourceBitmap)
        // set text for movie name
        holder.movieNameTextView.text = movie.name
        // TODO: set text for movie rating
        holder.movieRatingTextView.text = movie.rating.toString()

        // TODO: set text for movie review
        holder.movieReviewTextView.text = movie.review.toString()
//        holder.bunnyAgeTextView.text = resources?.getString(R.string.bunny_age,bunny.age)
    }
}
