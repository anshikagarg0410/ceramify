package com.igdtuw.ceramify
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

class MyPage2:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shops_main2)
        val textOne = findViewById<TextView>(R.id.text1)
        textOne.setOnClickListener {
            Toast.makeText(this, "text1 cliked", Toast.LENGTH_SHORT).show()
        }
        val myText = findViewById<TextView>(R.id.text2)
        myText.setOnClickListener {
            Toast.makeText(this, "text2 clicked", Toast.LENGTH_SHORT).show()
        }
        val icon1 = findViewById<ImageView>(R.id.icon1)
        val icon2 = findViewById<ImageView>(R.id.icon2)
        icon1.setOnClickListener {
            Toast.makeText(this, "icon1 clicked", Toast.LENGTH_SHORT).show()
        }
        icon2.setOnClickListener {
            Toast.makeText(this, "icon2 clicked", Toast.LENGTH_SHORT).show()
        }
        val myCard = findViewById<CardView>(R.id.myCard)
        val cardText = findViewById<TextView>(R.id.cardText)
        myCard.setOnClickListener {
            Toast.makeText(this, "Card clicked:${cardText.text}", Toast.LENGTH_SHORT).show()
        }
        val makeCard = findViewById<CardView>(R.id.makeCard)
        val cardText2 = findViewById<TextView>(R.id.cardText2)
        makeCard.setOnClickListener {
            Toast.makeText(this, "click me:${cardText2.text}", Toast.LENGTH_SHORT).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}



