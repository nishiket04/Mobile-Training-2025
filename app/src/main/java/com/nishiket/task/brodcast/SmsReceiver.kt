package com.nishiket.task.brodcast

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.nishiket.task.R

class SmsReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent?) {
        val builder = NotificationCompat.Builder(context, "FCM")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("New Message Alert")
            .setAutoCancel(true)
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(15, builder.build())
    }
}