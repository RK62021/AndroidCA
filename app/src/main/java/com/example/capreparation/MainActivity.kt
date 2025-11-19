package com.example.capreparation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Date
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    lateinit var issueDate:EditText
    lateinit var returnDate:EditText
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        issueDate = findViewById<EditText>(R.id.issueDateField)
        returnDate = findViewById<EditText>(R.id.returnDateField)
        btn = findViewById<Button>(R.id.btnSubmit)

        btn.setOnClickListener {
            var IssueDate = issueDate.text.toString()
            var ReturnDate = returnDate.text.toString()

            val today = LocalDate.now()

            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

            val returnDateParsed = LocalDate.parse(ReturnDate, formatter)

            if (today.isAfter(returnDateParsed)) {

                Toast.makeText(
                    this,
                    "you are fined Rs.100 per day after return date",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    this,
                    "Return in time",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }



    }
}