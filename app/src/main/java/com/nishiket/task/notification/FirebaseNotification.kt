package com.nishiket.task.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.nishiket.task.R

class FirebaseNotification : FirebaseMessagingService() {
    // creates token
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("TAG", "onNewToken: $token")
    }

    // receives notification form firebase
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("TAG", "From: ${message.from}")

        // Check if the message contains data payload
        message.data.isNotEmpty().let {
            Log.d("TAG", "Message data payload: ${message.data}")
        }

        // Check if the message contains a notification payload
        message.notification?.let {
            Log.d("TAG", "Message Notification Body: ${it.body}")
            if (it.imageUrl.toString().isNotEmpty()) {
                // show image notification
                showImageNotification(it)
            } else {
                // Show notification
                showNotification(it)
            }

        }
    }

    private fun showNotification(fcm: RemoteMessage.Notification) {
        // notification
        val notification = NotificationCompat.Builder(this, "FCM").setContentTitle(fcm.title)
            .setContentText(fcm.body).setSmallIcon(R.drawable.baseline_account_circle_23).build()
        // get instance of Notification manager
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Since Android Oreo, a notification channel is needed
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("FCM", "Channel for FCM", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }
        // send notification
        notificationManager.notify(0, notification)
    }

    private fun showImageNotification(fcm: RemoteMessage.Notification) {
        // image notification
        val notification = NotificationCompat.Builder(this, "FCM").setContentTitle(fcm.title)
            .setContentText(fcm.body).setSmallIcon(R.drawable.baseline_account_circle_23)
            .setLargeIcon(
                BitmapFactory.decodeStream( // decode that stream to bitmap
                    java.net.URL(
                        fcm.imageUrl.toString() // image url
                    ).openStream() // get image in stream
                )
            ).build()
        // get instance of Notification manager
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Since Android Oreo, a notification channel is needed
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("FCM", "Channel for FCM", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }
        // send notification
        notificationManager.notify(1, notification)
    }
}