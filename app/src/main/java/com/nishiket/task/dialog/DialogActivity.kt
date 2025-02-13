package com.nishiket.task.dialog

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.nishiket.task.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DialogActivity : AppCompatActivity() {
    private lateinit var alertDialog: Button
    private lateinit var listDialog: Button
    private lateinit var customDialog: Button
    private lateinit var forceDialog: Button
    private lateinit var itemDialog: Button
    private lateinit var materialDialog: Button
    private lateinit var multiChoiceDialog: Button
    private lateinit var dateDialog: Button
    private val calendar:Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        // finds all the id of view
        findId()

        // shows alert dialog box when clicked
        alertDialog.setOnClickListener {
            alertDialog()
        }

        // shows list dialog box when clicked
        listDialog.setOnClickListener {
            listDialog()
        }

        // shows singles choice dialog box when clicked
        itemDialog.setOnClickListener {
            singleChoiceDialog()
        }

        // shows multi choice dialog box when clicked
        multiChoiceDialog.setOnClickListener {
            multiChoiceDialog()
        }

        // shows force dialog box for input
        forceDialog.setOnClickListener {
            forceDialog()
        }

        // shows material dialog box
        materialDialog.setOnClickListener {
            materialDialog()
        }

        // custom view dialog box
        customDialog.setOnClickListener {
            customDialog()
        }

        // date dialog box
        dateDialog.setOnClickListener {
            dateDialog()
        }
    }

    // alert dialog box function
    fun alertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog box")
        builder.setMessage("This is an simple alert dialog box")
        builder.setIcon(R.drawable.baseline_account_circle_23)
        builder.setPositiveButton("Yes") { dialog, which ->
            dialog.cancel()
            Toast.makeText(this, "Pressed on Yes", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No") { dialog, which ->
            dialog.cancel()
            Toast.makeText(this, "Pressed on No", Toast.LENGTH_LONG).show()
        }
        builder.create().show()
    }

    // custom view Dialog box function
    fun customDialog() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.custom_dialog, null)
        builder.setView(view)
        val dialog = builder.create()
        view.findViewById<Button>(R.id.getName).setOnClickListener {
            dialog.dismiss()
            Toast.makeText(
                this,
                "${view.findViewById<EditText>(R.id.username).text.toString()}",
                Toast.LENGTH_LONG
            ).show()
        }
        dialog.show()
    }

    // material dialog box function
    fun materialDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Material Dialog")
            .setMessage("This is an Material Dialog")
            .setPositiveButton("Yes") { dialog, which ->
                dialog.cancel()
                Toast.makeText(this, "Pressed on Yes", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No") { dialog, which ->
                dialog.cancel()
                Toast.makeText(this, "Pressed on No", Toast.LENGTH_LONG).show()
            }
            .show()
    }

    // force input dialog box function
    fun forceDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog box")
        builder.setMessage("This is an forced alert dialog box")
        builder.setCancelable(false)
        builder.setPositiveButton("Yes") { dialog, which ->
            dialog.cancel()
            Toast.makeText(this, "Pressed on Yes", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No") { dialog, which ->
            dialog.cancel()
            Toast.makeText(this, "Pressed on No", Toast.LENGTH_LONG).show()
        }
        builder.create().show()
    }

    // radio button dialog box function
    fun singleChoiceDialog() {
        var number: String = "Nothing"
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog box")
        builder.setSingleChoiceItems(arrayOf("One", "Two", "Three"), 0) { dialog, which ->
            number = when (which) {
                0 -> "One"
                1 -> "Two"
                2 -> "Three"
                else -> "null"
            }
        }
        builder.setPositiveButton("Get Number") { dialog, which ->
            dialog.cancel()
            Toast.makeText(this, "Pressed on $number", Toast.LENGTH_LONG).show()
        }
        builder.create().show()
    }

    // list of items dialog box function
    fun listDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("List box")
        builder.setItems(arrayOf("One", "Two", "Three")) { dialog, which ->
            val number = when (which) {
                0 -> "One"
                1 -> "Two"
                2 -> "Three"
                else -> null
            }
            dialog.cancel()
            Toast.makeText(this, "Pressed On $number", Toast.LENGTH_LONG)

        }
        builder.setPositiveButton("Yes") { dialog, which ->
            dialog.cancel()
            Toast.makeText(this, "Pressed on Yes", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No") { dialog, which ->
            dialog.cancel()
            Toast.makeText(this, "Pressed on No", Toast.LENGTH_LONG).show()
        }
        builder.create().show()
    }

    // multi choice dialog box function
    fun multiChoiceDialog() {
        val number: MutableList<String> = mutableListOf()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog box")
        builder.setMultiChoiceItems(
            arrayOf("One", "Two", "Three"),
            null
        ) { dialog, which, isChecked ->
            when (which) {
                0 -> number.add("One")
                1 -> number.add("Two")
                2 -> number.add("Three")
            }
        }
        builder.setPositiveButton("Get Number") { dialog, which ->
            dialog.cancel()
            Toast.makeText(this, "Pressed on $number", Toast.LENGTH_LONG).show()
        }
        builder.create().show()
    }

    //date dialog box function
    fun dateDialog(){
        val datePickerDialog = DatePickerDialog(
            this, {DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                Toast.makeText(this,"selected date is $formattedDate",Toast.LENGTH_LONG).show()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    // Function to find id's of view
    fun findId() {
        alertDialog = findViewById(R.id.alertDialog)
        listDialog = findViewById(R.id.listDialog)
        customDialog = findViewById(R.id.customDialog)
        forceDialog = findViewById(R.id.forceDialog)
        itemDialog = findViewById(R.id.itemDialog)
        materialDialog = findViewById(R.id.materialDialog)
        multiChoiceDialog = findViewById(R.id.multiChoiceDialog)
        dateDialog = findViewById(R.id.dateDialog)
    }
}