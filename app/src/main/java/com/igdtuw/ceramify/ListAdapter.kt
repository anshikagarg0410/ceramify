package com.igdtuw.ceramify

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.igdtuw.ceramify.databinding.ListItemBinding

class ListAdapter(
    private val context: Context,
    private val dataList: ArrayList<ListData?>
) : BaseAdapter() {

    override fun getCount(): Int = dataList.size

    override fun getItem(position: Int): ListData? = dataList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ListItemBinding
        val view: View

        if (convertView == null) {
            binding = ListItemBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as ListItemBinding
        }

        val listItem = dataList[position]
        listItem?.let {
            // Set data to views
            binding.listImage.setImageResource(it.courseImage)
            binding.listTitle.text = it.courseTitle
            binding.listDetails.text = it.details
            binding.listButton.text = it.button

            // Register button click: choose activity based on course title
            binding.listButton.setOnClickListener {
                val intent = when (listItem.title) {
                    "SILVER COURSE - FOR BEGINNERS" -> Intent(context, DetailedActivity::class.java)
                    "GOLDEN COURSE - FOR INTERMEDIATES" -> Intent(context, DetailedActivity1::class.java)
                    "PLATINUM COURSE - FOR EXPERTS" -> Intent(context, DetailedActivityPlatinum::class.java)
                    else -> Intent(context, DetailedActivity::class.java)
                }

                // Pass course data to the detailed activity
                intent.putExtra("courseTitle", listItem.title)
                intent.putExtra("courseDescription", listItem.fullDescription)
                intent.putExtra("InstructorImage", listItem.instructorImage)
                intent.putExtra("instructorName", listItem.instructorName)

                context.startActivity(intent)
            }
        }

        return view
    }
}

