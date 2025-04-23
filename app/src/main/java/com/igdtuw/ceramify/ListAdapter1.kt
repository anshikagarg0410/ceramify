package com.igdtuw.ceramify

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter1(context: Context, private val dataArrayList: ArrayList<ListData1>) :
    ArrayAdapter<ListData1>(context, R.layout.list_item, dataArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val listImage = view.findViewById<ImageView>(R.id.imageWorkshop)
        val listTitlePrice = view.findViewById<TextView>(R.id.textWorkshopDetails)
        val listDesc = view.findViewById<TextView>(R.id.textDateTime)
        val rsvpText = view.findViewById<TextView>(R.id.textRSVP)

        val listData = getItem(position)

        listData?.let {
            listImage.setImageResource(it.image)
            listTitlePrice.text = "${it.name}\n${it.price}"
            listDesc.text = it.desc
        }

        rsvpText.setOnClickListener {
            val intent = Intent(context, WorkshopMainActivity2::class.java)
            intent.putExtra("workshopName", listData?.name ?: "Workshop")
            context.startActivity(intent)
        }

        return view
    }
}
