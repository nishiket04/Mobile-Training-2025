package com.nishiket.task.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nishiket.task.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}