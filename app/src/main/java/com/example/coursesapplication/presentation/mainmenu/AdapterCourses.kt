package com.example.coursesapplication.presentation.mainmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursesapplication.R
import com.example.coursesapplication.domain.Course
import com.example.coursesapplication.databinding.CoursItemBinding

class AdapterCourses(val listener : clickListener): RecyclerView.Adapter<AdapterCourses.CoursesHolder>() {

    var coursesList= mutableListOf<Course>()

    class CoursesHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = CoursItemBinding.bind(item)
        val imageList = listOf(R.drawable.course1, R.drawable.course2, R.drawable.course3)

        fun bind (course: Course, listener: clickListener) = with(binding){
            tvTitle.text = course.title
            tvInfo.text = course.text
            tvPrice.text = course.price
            imageItem.setImageResource(imageList[course.image])
            btnAddFavorite.setOnClickListener{
                listener.onClick(course)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.cours_item, parent,false)
        return CoursesHolder(view)
    }

    override fun getItemCount(): Int {
        return coursesList.size
    }

    override fun onBindViewHolder(holder: CoursesHolder, position: Int) {

        holder.bind(coursesList[position], listener)

    }

    interface clickListener{
        fun onClick(course: Course)
    }
}