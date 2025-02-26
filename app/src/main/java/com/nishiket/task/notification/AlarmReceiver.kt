package com.nishiket.task.notification

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.nishiket.task.R

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        Log.d("this", "notify")

        val builder = NotificationCompat.Builder(context, "FCM")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Alarm is running")
            .setAutoCancel(true)
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(12, builder.build())

    }

}