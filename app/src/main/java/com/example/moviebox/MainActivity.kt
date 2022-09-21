package com.example.moviebox

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.moviebox.data.DataSource
import com.example.moviebox.databinding.ActivityMainBinding
import com.example.moviebox.model.Movie
import java.io.IOException


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        var selectImage = findViewById<Button>(R.id.select_image)
//        var previewImage = findViewById<ImageView>(R.id.preview_image)

        selectImage.setOnClickListener {
            imageChooser()
        }
        val editText = findViewById<TextView>(R.id.movie_name_edit_text)
        val reviewText = findViewById<TextView>(R.id.movie_review_edit_text)

        val secondPage = findViewById<Button>(R.id.movie_list_btn)
        secondPage.setOnClickListener {
            val movies: MutableList<Movie> = DataSource.movies
            movies.add(
                Movie(
                    R.drawable.luca,
                    editText.text.toString(),
                    reviewText.text.toString(),
                    3
                )
            )
//            DataSource.movies = movies

            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)

        }
    }

    fun imageChooser(){
        val intent = Intent()
        intent.setType("image/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)

        launchSomeActivity.launch(intent)
    }

    var launchSomeActivity = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode
            == RESULT_OK
        ) {
            var previewImage = findViewById<ImageView>(R.id.preview_image)
            val data = result.data
            if (data != null
                && data.data != null
            ) {
                val selectedImageUri: Uri? = data.data
                val selectedImageBitmap: Bitmap
                try {
                    if(Build.VERSION.SDK_INT < 28){
                        selectedImageBitmap = MediaStore.Images.Media.getBitmap(
                            this.contentResolver,
                            selectedImageUri
                        )
                        previewImage.setImageBitmap(
                            selectedImageBitmap
                        )
                    } else{
                        val source = ImageDecoder.createSource(this.contentResolver,
                            selectedImageUri!!
                        )
                        val bitmap = ImageDecoder.decodeBitmap(source)
                        previewImage.setImageBitmap(
                            bitmap
                        )
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}