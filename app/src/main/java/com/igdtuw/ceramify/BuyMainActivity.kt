package com.igdtuw.ceramify

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import com.igdtuw.ceramify.GiftActivity
import com.igdtuw.ceramify.PersonalizedActivity
import com.igdtuw.ceramify.PremadeActivity
import com.igdtuw.ceramify.TrendingActivity
import com.igdtuw.ceramify.databinding.ActivityBuyMainBinding

class BuyMainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"


    private lateinit var binding: ActivityBuyMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBuyMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.Gift.setOnClickListener {
            startActivity(Intent(this, GiftActivity::class.java))
        }

        binding.trending.setOnClickListener {
            startActivity(Intent(this, TrendingActivity::class.java))
        }

        binding.premade.setOnClickListener {
            startActivity(Intent(this, PremadeActivity::class.java))
        }

        binding.personalized.setOnClickListener {
            startActivity(Intent(this, PersonalizedActivity::class.java))
        }
    }
}