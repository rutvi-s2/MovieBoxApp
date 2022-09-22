/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.moviebox.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.moviebox.MainActivity3
import com.example.moviebox.R
import com.example.moviebox.data.DataSource
import com.example.moviebox.databinding.ActivityMainBinding
import com.example.moviebox.model.Movie

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class MovieCardAdapter(
    private val context: Context,
    private val listener: OnItemClickListener
): RecyclerView.Adapter<MovieCardAdapter.MovieCardViewHolder>() {

    // initialize the data using the bunnies List found in DataSource
    private var movies: List<Movie> = DataSource.movies
    /**
     * Initialize view elements
     */
    inner class MovieCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!),
    View.OnClickListener{
        // declare and initialize all of the bunny list item UI components
        val movieImageView: ImageView = view!!.findViewById(R.id.movie_grid_image)
        val movieNameTextView: TextView = view!!.findViewById(R.id.movie_grid_name)

        init {
            if (view != null) {
                view.setOnClickListener(this)
            }
        }

        override fun onClick(p0: View?) {
//            val intent = Intent(this, MainActivity3::class.java)
//            startActivity(intent)
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position, movies)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, movies: List<Movie>)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCardViewHolder {
        // determine which list item should be used and set layout accordingly
        // grid vs vertical/horizontal

        var adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_grid_item, parent, false)
        // inflate layout and return
        return MovieCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
//        return size of bunnies data set
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieCardViewHolder, position: Int) {
        // set the resource for the current bunny
        val resources = context?.resources
        //get the data at the current position
        val movie = movies[position]
        holder.movieImageView.setImageBitmap(movie.imageResourceBitmap)
        //set text for name and age
        holder.movieNameTextView.text = movie.name
    }

}
