package com.nishiket.task.layouts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nishiket.task.R
import com.nishiket.task.activity.data_pass.Task2_Activity_Get_Data_From_Back_Stack
import com.nishiket.task.activity.lifecycle.Task1_Activity
import com.nishiket.task.layouts.color_game.ColorGameActivity
import com.nishiket.task.layouts.edit_profile.EditProfileActivity
import com.nishiket.task.layouts.signup.SignupActivity

class LayoutsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layouts)
        findViewById<Button>(R.id.task1).setOnClickListener{
            val i: Intent = Intent(this, SignupActivity::class.java)
            startActivity(i)
        }
        findViewById<Button>(R.id.task2).setOnClickListener{
            val i: Intent = Intent(this, EditProfileActivity::class.java)
            startActivity(i)
        }
        findViewById<Button>(R.id.task3).setOnClickListener{
            val i: Intent = Intent(this, ColorGameActivity::class.java)
            startActivity(i)
        }
    }
}