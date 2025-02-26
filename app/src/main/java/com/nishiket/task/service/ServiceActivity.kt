package com.nishiket.task.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nishiket.task.R

class ServiceActivity : AppCompatActivity() {
    private lateinit var start: Button
    private lateinit var stop: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        // assign Ids using function
        findId()
        // adding channel for notification
        val channel = NotificationChannel("Api","this is api call channel", NotificationManager.IMPORTANCE_HIGH)
        val notificaion = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificaion.createNotificationChannel(channel)

        // start the service with action start
        start.setOnClickListener {
            startService(Intent(this,CounterService::class.java).apply { action = State.START.toString() })
        }

        // stop the service with action stop
        stop.setOnClickListener {
            startService(Intent(this,CounterService::class.java).apply { action = State.STOP.toString() })
        }
    }

    // Function to find ids of the views
    fun findId() {
        start = findViewById(R.id.start)
        stop = findViewById(R.id.stop)
    }
}