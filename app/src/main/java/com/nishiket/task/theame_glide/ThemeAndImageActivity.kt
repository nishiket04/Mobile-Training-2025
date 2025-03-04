package com.nishiket.task.theame_glide

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil3.compose.AsyncImage
import coil3.imageLoader
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.target
import com.bumptech.glide.Glide
import com.nishiket.task.R

class ThemeAndImageActivity : AppCompatActivity() {
    private lateinit var glideImage: ImageView
    private lateinit var coilImage: ImageView
    private lateinit var darkRadio: RadioButton
    private lateinit var lightRadio: RadioButton
    private lateinit var systemRadio: RadioButton
    private lateinit var themeRadio: RadioGroup
    private val GLIDE_IMAGE =
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtnvAOajH9gS4C30cRF7rD_voaTAKly2Ntaw&s"
    private val COIL_IMAGE =
        "https://media.istockphoto.com/id/1280385511/photo/colorful-background.jpg?s=612x612&w=0&k=20&c=kj0PRQlgvWLzA1-1me6iZp5mlwsZhC4QlcvIEb1J1bs="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_and_image)
        // assign Id
        findId()

        Glide.with(this).load(GLIDE_IMAGE).placeholder(R.drawable.baseline_account_circle_23)
            .into(glideImage)
        imageLoader.enqueue(
            ImageRequest.Builder(this)
                .data(COIL_IMAGE)
                .target(coilImage)
                .build()
        )
        themeRadio.setOnCheckedChangeListener { radioGroup, i ->
            Log.d("TAG", "onCreate: in radio $i")
            when (i) {
                R.id.darkRadio -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                R.id.lightRadio -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                R.id.systemRadio -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }

    }

    // Function to find Ids
    fun findId() {
        glideImage = findViewById(R.id.glideImage)
        coilImage = findViewById(R.id.coilImage)
        darkRadio = findViewById(R.id.darkRadio)
        lightRadio = findViewById(R.id.lightRadio)
        systemRadio = findViewById(R.id.systemRadio)
        themeRadio = findViewById(R.id.themeRadio)
    }
}