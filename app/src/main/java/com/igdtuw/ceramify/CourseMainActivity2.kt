package com.igdtuw.ceramify

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.igdtuw.ceramify.databinding.ActivityCourseMain2Binding

class CourseMainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityCourseMain2Binding
    private lateinit var listAdapter: ListAdapter
    private val dataArrayList = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Correct binding reference to layout
        binding = ActivityCourseMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Prepare course list
        val courseList = listOf(
            ListData(
                R.drawable.course1,
                "SILVER COURSE",
                "SILVER COURSE - FOR BEGINNERS",
                "Duration – 7 DAYS\nPrice – Rs.399.00\nClasses – \n2 hours/day",
                "• 7-day offline course (2 hrs/day)\n• Hand-building: pinch, coil, slab\n• Participation Certificate",
                "REGISTER",
                R.drawable.potter1,
                "MR . SMITH"
            ),
            ListData(
                R.drawable.courses2,
                "GOLDEN COURSE",
                "GOLDEN COURSE - FOR INTERMEDIATES",
                "Duration – 14 DAYS\nPrice – Rs.799.00\nClasses – \n2 hours/day",
                "• 15-day offline course (2 hrs/day)\n• Wheel basics, decoration techniques\n• Skill Achievement Certificate",
                "REGISTER",
                R.drawable.lara,
                "MS. LARA"
            ),
            ListData(
                R.drawable.courses3,
                "PLATINUM COURSE",
                "PLATINUM COURSE - FOR EXPERTS",
                "Duration – 30 DAYS\nPrice – Rs.999.00\nClasses – \n2 hours/day",
                "• 30-day offline course (3 hrs/day)\n• Wheel mastery, glazing, firing\n• Expertise Certificate + Final Project",
                "REGISTER",
                R.drawable.rovert,
                "MR . ROBERT"
            )
        )

        dataArrayList.addAll(courseList)

        // Initialize and set adapter
        listAdapter = ListAdapter(this, dataArrayList)
        binding.listView.adapter = listAdapter

        // Handle item click
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, i, _ ->
            val selectedCourse = dataArrayList[i]
            selectedCourse?.let {
                val intent = Intent(this, DetailedActivity::class.java).apply {
                    putExtra("courseTitle", it.title)
                    putExtra("courseDescription", it.fullDescription)
                    putExtra("InstructorImage", it.instructorImage)
                    putExtra("InstructorName", it.instructorName)
                }
                startActivity(intent)
            }      }
    }
}
