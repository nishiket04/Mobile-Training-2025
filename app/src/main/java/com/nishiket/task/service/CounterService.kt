package com.nishiket.task.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import androidx.core.app.NotificationCompat
import com.nishiket.task.R

class CounterService: Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            State.START.toString() -> start()
            State.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun start(){
        val notification = NotificationCompat.Builder(this,"Api").setSmallIcon(R.mipmap.ic_launcher).setContentText("This is test").setContentTitle("Increasing Counter").build()
        startForeground(1,notification)
    }
}
enum class State{
    START,STOP;
}
