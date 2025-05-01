package com.example.coursesapplication.presentation.mainmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursesapplication.R
import com.example.coursesapplication.databinding.CoursItemBinding
import com.example.coursesapplication.domain.Course

class AdapterFavorites:RecyclerView.Adapter<AdapterFavorites.FavoritesHolder>() {

    val courseFavorites = mutableListOf<Course>()

    class FavoritesHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CoursItemBinding.bind(item)
        val imageList = listOf(R.drawable.course1, R.drawable.course2, R.drawable.course3)

        fun bind(course: Course) = with(binding){
            tvTitle.text = course.title
            tvInfo.text = course.text
            tvPrice.text = course.price
            imageItem.setImageResource(imageList[course.image])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cours_item, parent, false)
        return FavoritesHolder(view)
    }

    override fun getItemCount(): Int {
        return courseFavorites.size
    }

    override fun onBindViewHolder(holder: FavoritesHolder, position: Int) {
        holder.bind(courseFavorites[position])
    }
}