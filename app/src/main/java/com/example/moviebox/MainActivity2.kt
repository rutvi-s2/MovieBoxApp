package com.example.moviebox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.moviebox.adapter.MovieCardAdapter
import com.example.moviebox.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main2)

        binding.gridRecyclerView.adapter = MovieCardAdapter(
            applicationContext)

        // Specify fixed size to improve performance
        binding.gridRecyclerView.setHasFixedSize(true)

//        val thirdPage = findViewById<Button>(R.id.movielistbtn)
//        thirdPage.setOnClickListener {
//            val Intent = Intent(this,MainActivity3::class.java)
//            startActivity(Intent)
//        }
    }
}

