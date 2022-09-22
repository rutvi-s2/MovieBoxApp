package com.example.moviebox

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.moviebox.adapter.MovieCardAdapter
import com.example.moviebox.databinding.ActivityMain2Binding
import com.example.moviebox.model.Movie
import java.io.ByteArrayOutputStream


class MainActivity2 : AppCompatActivity(), MovieCardAdapter.OnItemClickListener{

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gridRecyclerView.adapter = MovieCardAdapter(
            applicationContext, this)

        // Specify fixed size to improve performance
        binding.gridRecyclerView.setHasFixedSize(true)
        val firstPage = findViewById<ImageButton>(R.id.add_movie_btn)
        firstPage.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
    // TODO: on click of a moviecardapater, open up fullscreenmovieadapter
    override fun onItemClick(position: Int, movies: List<Movie>) {
        val intent = Intent(this,MainActivity3::class.java)
//        val stream = ByteArrayOutputStream()
//        movies[position].imageResourceBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
//        val byteArray: ByteArray = stream.toByteArray()
//        intent.putExtra("movie_image", byteArray)
//        var bStream  =  ByteArrayOutputStream()
//        movies[position].imageResourceBitmap.compress(Bitmap.CompressFormat.PNG, 50, bStream)
//        val byteArray = bStream.toByteArray()
//        intent.putExtra("image", byteArray )
        intent.putExtra("movie_image", R.drawable.luca)
        intent.putExtra("movie_name", movies[position].name)
        intent.putExtra("movie_review", movies[position].review)
        intent.putExtra("movie_rating", movies[position].rating)
        startActivity(intent)
    }

}

