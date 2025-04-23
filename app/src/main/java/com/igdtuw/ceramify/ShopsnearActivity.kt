package com.igdtuw.ceramify

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.igdtuw.mypage1.R


class ShopsnearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shops_main)

        val textOne=findViewById<TextView>(R.id.text1)
        textOne.setOnClickListener{
            val intent=Intent(this, MyPage2::class.java)
            startActivity(intent)
            
        }
        val myText = findViewById<TextView>(R.id.text2)
        myText.setOnClickListener {
            Toast.makeText(this, "Text clicked!", Toast.LENGTH_SHORT).show()
        }
        val icon1=findViewById<ImageView>(R.id.icon1)
        val icon2=findViewById<ImageView>(R.id.icon2)
        icon1.setOnClickListener{
            Toast.makeText(this,"icon1 clicked",Toast.LENGTH_SHORT).show()
        }
        icon2.setOnClickListener {
            Toast.makeText(this,"icon2 clicked",Toast.LENGTH_SHORT).show()
        }
        val myCard=findViewById<CardView>(R.id.myCard)
        val cardText=findViewById<TextView>(R.id.cardText)
        myCard.setOnClickListener {
            Toast.makeText(this,"Card clicked: ${cardText.text}",Toast.LENGTH_SHORT).show()
        }
        val mayCard=findViewById<CardView>(R.id.mayCard)
        val cardText2=findViewById<TextView>(R.id.cardText2)
        mayCard.setOnClickListener {
            Toast.makeText(this,"clickon: ${cardText.text}",Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

}


