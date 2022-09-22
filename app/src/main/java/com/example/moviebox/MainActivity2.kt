package com.example.moviebox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.moviebox.adapter.MovieCardAdapter
import com.example.moviebox.data.DataSource
import com.example.moviebox.data.DataSource.movies
import com.example.moviebox.databinding.ActivityMain2Binding
import com.example.moviebox.model.Movie

class MainActivity2 : AppCompatActivity(), MovieCardAdapter.OnItemClickListener{

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main2)

        binding.gridRecyclerView.adapter = MovieCardAdapter(
            applicationContext, this)

        // Specify fixed size to improve performance
        binding.gridRecyclerView.setHasFixedSize(true)

//        val thirdPage = findViewById<Button>(R.id.movielistbtn)
//        thirdPage.setOnClickListener {
//            val Intent = Intent(this,MainActivity3::class.java)
//            startActivity(Intent)
//        }


//        val thirdPage: ImageView = findViewById(R.id.movie_grid_image)
//        thirdPage.setOnClickListener {
//
//            val intent = Intent(this,MainActivity3::class.java)
//            startActivity(intent)
//
//        }
    }
    // TODO: on click of a moviecardapater, open up fullscreenmovieadapter
    override fun onItemClick(position: Int) {
        val intent = Intent(this,MainActivity3::class.java)
//        intent.putExtra("some_object", movies[position])
//        movies[position]
        startActivity(intent)
    }

}

