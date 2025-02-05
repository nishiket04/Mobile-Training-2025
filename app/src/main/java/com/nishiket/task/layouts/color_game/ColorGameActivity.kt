package com.nishiket.task.layouts.color_game

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nishiket.task.R

class ColorGameActivity : AppCompatActivity() {
    private lateinit var red:FrameLayout
    private lateinit var green:FrameLayout
    private lateinit var white:FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_game)
        findId()
        red.setOnClickListener{
            red.visibility = View.GONE
        }
        green.setOnClickListener{
            green.visibility = View.GONE
        }
        white.setOnClickListener{
            white.visibility = View.GONE
        }
    }

    fun findId(){
        red = findViewById(R.id.red)
        green = findViewById(R.id.green)
        white = findViewById(R.id.white)
    }
}