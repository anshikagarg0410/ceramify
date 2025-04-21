package com.igdtuw.ceramify

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.igdtuw.ceramify.R

class DetailedActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed1) // Make sure layout file matches

        // 🔗 Reference views
        val titleTextView = findViewById<TextView>(R.id.courseTitle)
        val descriptionTextView = findViewById<TextView>(R.id.courseDescription)
        val instructorImageView = findViewById<ImageView>(R.id.imageView5)
        val backButton = findViewById<ImageView>(R.id.imageView3)
        val instructorNameTextView = findViewById<TextView>(R.id.textView12)

        val nameEditText = findViewById<EditText>(R.id.editTextText3)
        val emailEditText = findViewById<EditText>(R.id.editTextText4)
        val phoneEditText = findViewById<EditText>(R.id.editTextPhone)
        val addressEditText = findViewById<EditText>(R.id.editTextText8)
        val genderDropdown = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView8)
        val payButton = findViewById<Button>(R.id.payButton)

        // 📦 Get data from intent
        val title = intent.getStringExtra("courseTitle")
        val description = intent.getStringExtra("courseDescription")
        val imageRes = intent.getIntExtra("InstructorImage", R.drawable.lara) // Default
        val instructorName = intent.getStringExtra("instructorName")

        // 🎯 Set values into views
        titleTextView.text = title
        descriptionTextView.text = description
        instructorImageView.setImageResource(imageRes)
        instructorNameTextView.text = "INSTRUCTOR NAME\n$instructorName"

        // 🔙 Back button functionality
        backButton.setOnClickListener {
            finish()
        }

        // ♂️♀️ Gender dropdown
        val genderOptions = listOf("Male", "Female", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, genderOptions)
        genderDropdown.setAdapter(adapter)
        genderDropdown.setOnClickListener {
            genderDropdown.showDropDown()
        }

        // 💳 Register button functionality
        payButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val address = addressEditText.text.toString().trim()
            val gender = genderDropdown.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty() &&
                phone.isNotEmpty() && address.isNotEmpty() && gender.isNotEmpty()
            ) {
                Toast.makeText(this, "You are registered!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
