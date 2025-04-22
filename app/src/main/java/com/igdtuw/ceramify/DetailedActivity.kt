package com.igdtuw.ceramify

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore
import com.igdtuw.ceramify.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()

        binding.imageView3.setOnClickListener {
            finish()
        }

        val image = intent.getIntExtra("InstructorImage", R.drawable.potter1)
        val title = intent.getStringExtra("courseTitle")
        val description = intent.getStringExtra("courseDescription")
        val instructorName = intent.getStringExtra("InstructorName")

        binding.imageView5.setImageResource(image)
        binding.courseTitle.text = title
        binding.courseDescription.text = description
        binding.textView12.text = "INSTRUCTOR NAME\n$instructorName"

        val genderOptions = listOf("Male", "Female", "Other")
        val genderAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            genderOptions
        )
        val genderDropdown = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView8)
        genderDropdown.setAdapter(genderAdapter)
        genderDropdown.setOnClickListener {
            genderDropdown.showDropDown()
        }

        binding.payButton.setOnClickListener {
            val name = binding.editTextText3.text.toString().trim()
            val email = binding.editTextText4.text.toString().trim()
            val phone = binding.editTextPhone.text.toString().trim()
            val address = binding.editTextText8.text.toString().trim()
            val gender = genderDropdown.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty() &&
                phone.isNotEmpty() && address.isNotEmpty() && gender.isNotEmpty()
            ) {
                val userData = hashMapOf(
                    "name" to name,
                    "email" to email,
                    "phone" to phone,
                    "address" to address,
                    "gender" to gender,
                    "courseTitle" to title,
                    "instructorName" to instructorName
                )

                db.collection("registrations")
                    .add(userData)
                    .addOnSuccessListener {
                        Toast.makeText(this, "You are registered!", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failed to register: ${it.message}", Toast.LENGTH_LONG).show()
                    }

            } else {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
