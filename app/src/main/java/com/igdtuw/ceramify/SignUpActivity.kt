package com.igdtuw.ceramify

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.content.Intent


class SignUpActivity : AppCompatActivity() {
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signUpButton = findViewById<Button>(R.id.btnSignUp)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etMail = findViewById<TextInputEditText>(R.id.etMail)
        val etPassword= findViewById<TextInputEditText>(R.id.etPassword)
        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        signUpButton.setOnClickListener {
            val name = etName.text.toString()
            val mail = etMail.text.toString()
            val password = etPassword.text.toString()
            val username= etUsername.text.toString()
            val user= User(name, mail, password,username)

            val database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(username).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                val intent= Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }


    }
}