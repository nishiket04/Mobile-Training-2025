package com.nishiket.task.notification

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.FirebaseApp
import com.nishiket.task.R
import java.util.Calendar

class NotificationActivity : AppCompatActivity() {
    private lateinit var scheduled_notification: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        FirebaseApp.initializeApp(this)

        scheduled_notification = findViewById(R.id.scheduled_notification)

        scheduled_notification.setOnClickListener {
            // calls function to set notification
            setNotification()
        }
    }

    // Function to show notification in 10 sec
    private fun setNotification() {
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            100,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // Setting the specific time for the alarm manager to trigger the intent, in this example, the alarm is set to go off at 23:30, update the time according to your need
        val calendar = Calendar.getInstance()

        // set the time of broadcast
        val next = calendar.get(Calendar.SECOND) + 10

        // set the time in calendar object
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, next)

        // Starts the alarm manager
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }
}