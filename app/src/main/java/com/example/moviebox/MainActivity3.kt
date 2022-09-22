package com.example.moviebox

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.moviebox.data.DataSource
import com.example.moviebox.databinding.ActivityMain3Binding
import com.example.moviebox.model.Movie

class MainActivity3 : AppCompatActivity(){
    // declare binding varaible to set text for third screen
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        // set the binding variable
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        // create intent for the user to view the second screen
        val secondPage = findViewById<ImageButton>(R.id.movie_list_btn)
        secondPage.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        // create the intent for the user to view the first screen (input info screen)
        val firstPage = findViewById<ImageButton>(R.id.add_movie_btn)
        firstPage.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        // retrieve the movie name, movie rating, and movie review from the intent and set
        // the appropriate text view to display on screen 3.

        // for the image set the imageBitmap on the third screen by looping through
        // the list of movies and looking for the movie that was clicked on. Retrieve that
        // imageResourceBitmap and set it on the third screen.
        val extras = intent.extras
        val specific_movie_name = findViewById<TextView>(R.id.full_screen_movie_name)
        val specific_movie_rating = findViewById<TextView>(R.id.full_screen_movie_rating)
        val specific_movie_review = findViewById<TextView>(R.id.full_screen_movie_review)
        val specific_movie_image = findViewById<ImageView>(R.id.full_screen_movie_image)
        if (extras != null) {
            specific_movie_name.text = extras.getString("movie_name")
            specific_movie_rating.text = extras.getString("movie_rating")
            specific_movie_review.text = extras.getString("movie_review")
            val movies: MutableList<Movie> = DataSource.movies
            for (movie in movies){
                if (movie.name == specific_movie_name.text){
                    specific_movie_image.setImageBitmap(movie.imageResourceBitmap)
                    break
                }
            }
        }


    }


}