package com.example.moviebox

import android.R.attr
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import com.example.moviebox.data.DataSource
import com.example.moviebox.databinding.ActivityMainBinding
import com.example.moviebox.model.Movie
import java.io.IOException


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var imageResourceBitmap: Bitmap;
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
        val ratingNumber = when (binding.ratingOptions.checkedRadioButtonId) {
            R.id.option_one_star -> 1
            R.id.option_two_star -> 2
            R.id.option_three_star -> 3
            else -> 4
        }

        val secondPage = findViewById<ImageButton>(R.id.movie_list_btn)
        secondPage.setOnClickListener {
            val movies: MutableList<Movie> = DataSource.movies
            movies.add(
                Movie(
                    imageResourceBitmap,
                    editText.text.toString(),
                    reviewText.text.toString(),
                    ratingNumber
                )
            )

            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)

        }

    }

    private fun imageChooser(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        launchSomeActivity.launch(intent)
    }

    private var launchSomeActivity = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode  == RESULT_OK) {
            var previewImage = findViewById<ImageView>(R.id.preview_image)
            val data = result.data
            if (data != null && data.data != null) {
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
                        imageResourceBitmap = selectedImageBitmap
                    } else{
                        val source = ImageDecoder.createSource(this.contentResolver,
                            selectedImageUri!!
                        )
                        val bitmap = ImageDecoder.decodeBitmap(source)
                        previewImage.setImageBitmap(
                            bitmap
                        )
                        imageResourceBitmap = bitmap
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}