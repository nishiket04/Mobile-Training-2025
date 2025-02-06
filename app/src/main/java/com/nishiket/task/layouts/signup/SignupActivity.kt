package com.nishiket.task.layouts.signup

import android.app.DatePickerDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nishiket.task.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class SignupActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var submit:Button
//    private lateinit var dob:EditText
    private val calendar = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        findId()
        progressBar.visibility = View.GONE
        submit.setOnClickListener {
            submit.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.GONE
                submit.visibility = View.VISIBLE
           },5000)
        }
//        dob.isFocusable = false
//        dob.setOnClickListener{ view ->
//            showDatePicker()
//        }
    }
    fun findId(){
        progressBar = findViewById(R.id.progress_circular)
        submit = findViewById(R.id.submit)
//        dob = findViewById(R.id.dob)
    }
//    private fun showDatePicker() {
//        val datePickerDialog = DatePickerDialog(
//            this, {DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
//                val selectedDate = Calendar.getInstance()
//                selectedDate.set(year, monthOfYear, dayOfMonth)
//                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
//                val formattedDate = dateFormat.format(selectedDate.time)
//                dob.setText("$formattedDate")
//            },
//            calendar.get(Calendar.YEAR),
//            calendar.get(Calendar.MONTH),
//            calendar.get(Calendar.DAY_OF_MONTH)
//        )
//        // Show the DatePicker dialog
//        datePickerDialog.show()
//    }
}