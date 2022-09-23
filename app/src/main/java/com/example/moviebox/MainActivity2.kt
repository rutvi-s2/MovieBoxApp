package com.example.moviebox

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.moviebox.adapter.MovieCardAdapter
import com.example.moviebox.databinding.ActivityMain2Binding
import com.example.moviebox.model.Movie


class MainActivity2 : AppCompatActivity(), MovieCardAdapter.OnItemClickListener{

    private lateinit var binding: ActivityMain2Binding
    // Creates layout for 2nd page and makes it scrollable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gridRecyclerView.adapter = MovieCardAdapter(
            applicationContext, this)

        // Specify fixed size to improve performance
        binding.gridRecyclerView.setHasFixedSize(true)
        val firstPage = binding.addMovieBtn
        firstPage.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    // when moviecardadapter is clicked, send the data over the intent and start the intent
    // for screen 3
    override fun onItemClick(position: Int, movies: List<Movie>) {
        val intent = Intent(this,MainActivity3::class.java)
        intent.putExtra("movie_name", movies[position].name)
        intent.putExtra("movie_review", movies[position].review)
        intent.putExtra("movie_rating", movies[position].rating)
        startActivity(intent)
    }

}

