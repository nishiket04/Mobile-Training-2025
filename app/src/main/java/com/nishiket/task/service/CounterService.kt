package com.nishiket.task.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import androidx.core.app.NotificationCompat
import com.nishiket.task.R
import com.nishiket.task.retrofit.Retrofit
import com.nishiket.task.retrofit.RetrofitInstance
import com.nishiket.task.retrofit.Success
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CounterService : Service() {
    private var counter: Int = 0
    private val retrofit: Retrofit =
        RetrofitInstance.getInstanceCounter().create(Retrofit::class.java)

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            State.START.toString() -> start()
            State.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun start() {
        val notification =
            NotificationCompat.Builder(this, "Api").setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("This is test").setContentTitle("Increasing Counter").build()
        startForeground(1, notification)
        Handler(Looper.getMainLooper()).post(object : Runnable {
            override fun run() {
                val call = retrofit.updateCounter("nishiket", counter.toString())
                call.enqueue(object : Callback<Success> {
                    override fun onResponse(p0: Call<Success>, p1: Response<Success>) {

                    }

                    override fun onFailure(p0: Call<Success>, p1: Throwable) {

                    }

                })
                counter++
                Handler(Looper.getMainLooper()).postDelayed(this, 5*60*1000)
            }
        })

    }
}

enum class State {
    START, STOP;
}
