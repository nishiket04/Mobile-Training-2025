package com.nishiket.task.sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nishiket.task.R

class HomeActivity : AppCompatActivity() {
    private lateinit var welcomeTextView:TextView
    private lateinit var logOutButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        // assign Id
        findId()

        val sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE)
        val loginActivityIntent = Intent(this,LoginActivity::class.java)

        welcomeTextView.text = "Welcome" + sharedPreferences.getString("userName","No User") // set user name in welcome screen

        logOutButton.setOnClickListener {
            sharedPreferences.edit().clear().apply() // clear all the data of sp
            startActivity(loginActivityIntent) // go to login page
            finish() // kill the activity
        }
    }

    // Function to find Id's of the view
    fun findId(){
        welcomeTextView = findViewById(R.id.welcomeTextView)
        logOutButton = findViewById(R.id.logOutButton)
    }
}