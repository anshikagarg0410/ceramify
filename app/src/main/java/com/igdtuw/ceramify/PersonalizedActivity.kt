package com.igdtuw.ceramify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.igdtuw.buypage.databinding.ActivityPersonalizedBinding
import com.igdtuw.buypage.databinding.ActivityTrendingBinding

class PersonalizedActivity : AppCompatActivity() {
    private lateinit var submit: Button
    private lateinit var productdescription: EditText
    private lateinit var uploadimagebutton: Button
    private lateinit var binding: ActivityPersonalizedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPersonalizedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        submit = findViewById(R.id.submitBtn)
        uploadimagebutton = findViewById(R.id.uploadImageBtn)
        binding.submitBtn.setOnClickListener {
            Toast.makeText(this, "Successfully submited!!", Toast.LENGTH_SHORT).show()
        }


    }
}