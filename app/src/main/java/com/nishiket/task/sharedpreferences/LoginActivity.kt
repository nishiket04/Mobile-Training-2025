package com.nishiket.task.sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nishiket.task.R

class LoginActivity : AppCompatActivity() {
    private lateinit var userNameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // assign Id
        findId()

        val homePageIntent = Intent(this, HomeActivity::class.java)
        val sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE)

        if (sharedPreferences.getBoolean("isLogin", false)) { // if user is already logIn
            startActivity(homePageIntent) // go to home activity
        }

        loginButton.setOnClickListener {
            val userName = userNameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (userName.isEmpty() || password.isEmpty()) { // if one the filed is empty then show toast
                Toast.makeText(this, "Please enter all the filed to continue", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }
            val editableSharedPreferences = sharedPreferences.edit() // get editable shared preference reference
            editableSharedPreferences.putString("userName", userName).apply() // put user name
            editableSharedPreferences.putString("password", password).apply() // put password
            editableSharedPreferences.putBoolean("isLogin", true).apply() // put isLogin true
            startActivity(homePageIntent) // go to Home page
            finish() // kill activity
        }
    }

    // Function to find Id's of the view
    fun findId() {
        userNameEditText = findViewById(R.id.userNameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
    }
}