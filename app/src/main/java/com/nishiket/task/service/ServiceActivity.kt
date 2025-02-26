package com.nishiket.task.service

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nishiket.task.R

class ServiceActivity : AppCompatActivity() {
    private lateinit var start:Button
    private lateinit var stop:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        // assign Ids using function
        findId()
    }

    // Function to find ids of the views
    fun findId(){
        start = findViewById(R.id.start)
        stop = findViewById(R.id.stop)
    }
}