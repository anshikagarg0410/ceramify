package com.igdtuw.ceramify
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.igdtuw.ceramify.databinding.ActivityPremadeBinding


class PremadeActivity : AppCompatActivity() {
    private lateinit var addtocartbutn1: Button
    private lateinit var addtocartbutn2: Button
    private lateinit var binding: ActivityPremadeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPremadeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addtocartbutn1 = findViewById(R.id.addToCartBtn1)
        addtocartbutn2 = findViewById(R.id.addToCartBtn2)

        binding.addToCartBtn1.setOnClickListener {
            Toast.makeText(this, "Added in cart!!", Toast.LENGTH_SHORT).show()
        }
        binding.addToCartBtn2.setOnClickListener {
            Toast.makeText(this, "Added in cart!!", Toast.LENGTH_SHORT).show()
        }


    }

}