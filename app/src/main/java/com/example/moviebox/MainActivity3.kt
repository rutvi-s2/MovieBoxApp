package com.example.moviebox

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.moviebox.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity(){

    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        val specific_movie_name = findViewById<TextView>(R.id.full_screen_movie_name)
        val specific_movie_rating = findViewById<TextView>(R.id.full_screen_movie_rating)
        val specific_movie_review = findViewById<TextView>(R.id.full_screen_movie_review)
        val specific_movie_image = findViewById<ImageView>(R.id.full_screen_movie_image)
        if (extras != null) {
            val foodBank = extras.getString("FOOD_BANK")
            val address = extras.getString("STREET_ADDRESS")
            specific_movie_name.text = extras.getString("movie_name")
            specific_movie_rating.text = extras.getString("movie_rating")
            specific_movie_review.text = extras.getString("movie_review")
            specific_movie_image.setImageBitmap(extras.getParcelable("movie_image"))

        }
//

    }


}