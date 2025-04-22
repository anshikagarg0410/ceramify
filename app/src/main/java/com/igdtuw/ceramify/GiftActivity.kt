package com.igdtuw.ceramify

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.igdtuw.ceramify.databinding.ActivityGiftBinding

class GiftActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGiftBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflate layout using ViewBinding
        binding = ActivityGiftBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set onClickListeners
        binding.addToCartBtn1.setOnClickListener {
            Toast.makeText(this, "Added in cart!!", Toast.LENGTH_SHORT).show()
        }

        binding.addToCartBtn2.setOnClickListener {
            Toast.makeText(this, "Added in cart!!", Toast.LENGTH_SHORT).show()
        }
    }
}
