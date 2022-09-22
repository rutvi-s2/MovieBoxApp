package com.example.moviebox

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.moviebox.databinding.ActivityMain3Binding
import java.io.ByteArrayOutputStream


class MainActivity3 : AppCompatActivity(){

    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val secondPage = findViewById<ImageButton>(R.id.movie_list_btn)
        secondPage.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        val firstPage = findViewById<ImageButton>(R.id.add_movie_btn)
        firstPage.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        val extras = intent.extras
        val specific_movie_name = findViewById<TextView>(R.id.full_screen_movie_name)
        val specific_movie_rating = findViewById<TextView>(R.id.full_screen_movie_rating)
        val specific_movie_review = findViewById<TextView>(R.id.full_screen_movie_review)
        val specific_movie_image = findViewById<ImageView>(R.id.full_screen_movie_image)
        if (extras != null) {
            specific_movie_name.text = extras.getString("movie_name")
            specific_movie_rating.text = extras.getInt("movie_rating").toString()
            specific_movie_review.text = extras.getString("movie_review")
            specific_movie_image.setImageResource(extras.getInt("movie_image"))
//            var bitmap : Bitmap? =null
//            if (intent.hasExtra("movie_image")){
//                //convert to bitmap
//                val byteArray = intent.getByteArrayExtra("image")
//                if (byteArray != null) {
//                    bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
//                }
//                if (bitmap != null) {
//                    //Convert bitmap to BitmapDrawable
//                    var bitmapDrawable = BitmapDrawable( resources , bitmap)
//                    specific_movie_image.setImageDrawable(bitmapDrawable)
//                }
////                specific_movie_image.setImageBitmap(bitmap)
//            }

//            specific_movie_image.setImageResource(extras.getInt("movie_image"))
//            specific_movie_image.setImageBitmap(extras.getParcelable("movie_image"))
//            val byteArray = intent.getByteArrayExtra("movie_image")
//            val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)
//            specific_movie_image.setImageBitmap(bmp)
        }


    }


}