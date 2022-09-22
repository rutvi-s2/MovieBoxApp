package com.example.moviebox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviebox.adapter.MovieCardAdapter
import com.example.moviebox.databinding.ActivityMain2Binding
import com.example.moviebox.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity(){

//    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
//        binding = ActivityMain3Binding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.fullScreenRecyclerView.adapter = MovieCardAdapter(
//            applicationContext)
//
//        // Specify fixed size to improve performance
//        binding.fullScreenRecyclerView.setHasFixedSize(true)
    }


}