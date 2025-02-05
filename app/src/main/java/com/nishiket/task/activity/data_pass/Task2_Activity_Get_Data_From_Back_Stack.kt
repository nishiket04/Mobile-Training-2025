package com.nishiket.task.activity.data_pass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.nishiket.task.R

class Task2_Activity_Get_Data_From_Back_Stack : AppCompatActivity() {
    val newWay = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){res->
        if(res.resultCode == Activity.RESULT_OK){
            val data: Intent? = res.data
            val message = data?.getStringExtra("message")
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2_get_data_from_back_stack)
        findViewById<Button>(R.id.go_to_second_activity).setOnClickListener{
            val i:Intent = Intent(this, Task2_Activity_2::class.java)
            newWay.launch(i)
        }
    }
}