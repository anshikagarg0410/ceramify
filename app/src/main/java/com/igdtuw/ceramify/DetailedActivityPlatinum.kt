package com.igdtuw.ceramify

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class DetailedActivityPlatinum : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed1)

        db = FirebaseFirestore.getInstance()

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

        val title = intent.getStringExtra("courseTitle")
        val description = intent.getStringExtra("courseDescription")
        val imageRes = intent.getIntExtra("InstructorImage", R.drawable.rovert)
        val instructorName = intent.getStringExtra("InstructorName")

        titleTextView.text = title
        descriptionTextView.text = description
        instructorImageView.setImageResource(imageRes)
        instructorNameTextView.text = "INSTRUCTOR NAME\n$instructorName"

        backButton.setOnClickListener { finish() }

        val genderOptions = listOf("Male", "Female", "Other")
        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, genderOptions)
        genderDropdown.setAdapter(genderAdapter)
        genderDropdown.setOnClickListener { genderDropdown.showDropDown() }

        payButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val address = addressEditText.text.toString().trim()
            val gender = genderDropdown.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()
                && address.isNotEmpty() && gender.isNotEmpty()
            ) {
                val registrationData = hashMapOf(
                    "name" to name,
                    "email" to email,
                    "phone" to phone,
                    "address" to address,
                    "gender" to gender,
                    "courseTitle" to title,
                    "instructorName" to instructorName
                )

                db.collection("platinum_registrations")
                    .add(registrationData)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Registration successful!", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
                    }
            } else {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
