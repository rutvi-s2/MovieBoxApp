package com.example.moviebox

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.moviebox.data.DataSource
import com.example.moviebox.databinding.ActivityMainBinding
import com.example.moviebox.model.Movie
import java.io.IOException


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var imageResourceBitmap: Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val selectImage = findViewById<Button>(R.id.select_image)

        imageResourceBitmap = BitmapFactory.decodeResource(resources, R.drawable.no_image_preview);

        selectImage.setOnClickListener {
            imageChooser()
        }

        // Lets user include a review with a rating, review, and title
        val submitReview = findViewById<Button>(R.id.submit_button)
        submitReview.setOnClickListener {
            val editText = findViewById<TextView>(R.id.movie_name_edit_text)
            val reviewText = findViewById<TextView>(R.id.movie_review_edit_text)
            val ratingNumber = when (findViewById<RadioGroup>(R.id.rating_options).checkedRadioButtonId) {
                R.id.option_one_star -> "1 Star"
                R.id.option_two_star -> "2 Stars"
                R.id.option_three_star -> "3 Stars"
                else -> "4 Stars"
            }
            // Adds the new review to the list
            val movies: MutableList<Movie> = DataSource.movies
            movies.add(
                Movie(
                    imageResourceBitmap,
                    editText.text.toString(),
                    reviewText.text.toString(),
                    ratingNumber
                )
            )
            // Takes the user to their reviews after they have
            // submitted a review
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        // If user clicks on the movie button, it will take them to the
        // second page, the list of movies
        val secondPage = findViewById<ImageButton>(R.id.movie_list_btn)
        secondPage.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }

    // Allows the user to upload a photo
    // Takes the user to another application to choose a photo
    private fun imageChooser(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        launchSomeActivity.launch(intent)
    }

    // Gets the image the user input and displays the image
    private var launchSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode  == RESULT_OK) {
            //image view to preview an image
            val previewImage = findViewById<ImageView>(R.id.preview_image)
            val data = result.data
            //check if there is a selected image
            if (data != null && data.data != null) {
                val selectedImageUri: Uri? = data.data
                val selectedImageBitmap: Bitmap
                try {
                    //in order to support all SDK versions, get bitmap in various ways
                    if(Build.VERSION.SDK_INT < 28){
                        //use getBitmap function if older version is running and set image view's
                        //bitmap to the selectedImageBitmap
                        selectedImageBitmap = MediaStore.Images.Media.getBitmap(
                            this.contentResolver,
                            selectedImageUri
                        )
                        previewImage.setImageBitmap(
                            selectedImageBitmap
                        )
                        imageResourceBitmap = selectedImageBitmap
                    } else{
                        //use source and decodeBitmap function if newer version is running and set
                        //image view's bitmap to the selectedImageBitmap
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