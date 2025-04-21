package com.igdtuw.ceramify


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.igdtuw.ceramify.R

class DetailedActivityPlatinum : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed1)


        val titleTextView = findViewById<TextView>(R.id.courseTitle)
        val descriptionTextView = findViewById<TextView>(R.id.courseDescription)
        val instructorImageView = findViewById<ImageView>(R.id.imageView5)
        val backButton = findViewById<ImageView>(R.id.imageView3)
        val instructorNameTextView = findViewById<TextView>(R.id.textView12)


        val title = intent.getStringExtra("courseTitle")
        val description = intent.getStringExtra("courseDescription")
        val imageRes = intent.getIntExtra("InstructorImage", R.drawable.rovert)
        val instructorName = intent.getStringExtra("instructorName")


        titleTextView.text = title
        descriptionTextView.text = description
        instructorImageView.setImageResource(imageRes)
        instructorNameTextView.text = "INSTRUCTOR NAME\n$instructorName"


        backButton.setOnClickListener {
            finish()
        }


        val nameEditText = findViewById<EditText>(R.id.editTextText3)
        val emailEditText = findViewById<EditText>(R.id.editTextText4)
        val phoneEditText = findViewById<EditText>(R.id.editTextPhone)
        val addressEditText = findViewById<EditText>(R.id.editTextText8)
        val genderDropdown = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView8)
        val payButton = findViewById<Button>(R.id.payButton)


        val genderOptions = listOf("Male", "Female", "Other")
        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, genderOptions)
        genderDropdown.setAdapter(genderAdapter)

        payButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val address = addressEditText.text.toString().trim()
            val gender = genderDropdown.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() &&
                address.isNotEmpty() && gender.isNotEmpty()) {
                Toast.makeText(this, "You are registered!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
