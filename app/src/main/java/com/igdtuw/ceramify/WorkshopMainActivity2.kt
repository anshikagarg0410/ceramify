// WorkshopMainActivity2.kt
package com.igdtuw.ceramify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.igdtuw.ceramify.databinding.ActivityWorkshopMain2Binding

class WorkshopMainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityWorkshopMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkshopMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val workshopName = intent.getStringExtra("workshopName") ?: "Workshop"

        val fragment1 = Fragment1()
        val bundle = Bundle()
        bundle.putString("workshopName", workshopName)
        fragment1.arguments = bundle
        replaceFragment(fragment1)

        binding.fragment1Btn.setOnClickListener {
            val f1 = Fragment1()
            f1.arguments = bundle
            replaceFragment(f1)
        }

        binding.fragment2Btn.setOnClickListener {
            val f2 = Fragment2()
            f2.arguments = bundle
            replaceFragment(f2)
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}