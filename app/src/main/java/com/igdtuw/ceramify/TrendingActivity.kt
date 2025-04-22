package com.igdtuw.ceramify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.igdtuw.ceramify.databinding.ActivityTrendingBinding


class TrendingActivity : AppCompatActivity() {
    private lateinit var addtocartbutton: Button
    private lateinit var cartbutton: Button
    private lateinit var binding: ActivityTrendingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTrendingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addtocartbutton = findViewById(R.id.addToCartBtn1)
        cartbutton = findViewById(R.id.addToCartBtn2)

        binding.addToCartBtn1.setOnClickListener {
            Toast.makeText(this, "Added in cart!!", Toast.LENGTH_SHORT).show()
        }
        binding.addToCartBtn2.setOnClickListener {
            Toast.makeText(this, "Added in cart!!", Toast.LENGTH_SHORT).show()
        }


    }
}