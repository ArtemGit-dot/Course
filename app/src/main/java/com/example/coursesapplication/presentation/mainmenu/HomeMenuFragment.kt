package com.example.coursesapplication.presentation.mainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.coursesapplication.R
import com.example.coursesapplication.databinding.FragmentHomeMenuBinding
import com.example.coursesapplication.domain.Course

class HomeMenuFragment : Fragment(), AdapterCourses.clickListener {

    private lateinit var binding: FragmentHomeMenuBinding
    val adapterCourses = AdapterCourses(this)
    lateinit var viewModel: MainMenuFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerViewCourse
        recyclerView.adapter = adapterCourses
        viewModel = MainMenuFragmentViewModel()

        viewModel = ViewModelProvider(requireActivity())[MainMenuFragmentViewModel::class.java]

        viewModel.loadCourses()

        viewModel.courseList.observe(viewLifecycleOwner){ courses ->
            adapterCourses.coursesList.addAll(courses)
            adapterCourses.notifyDataSetChanged()

            if(viewModel.imageNumbers.value.isNullOrEmpty()) {
                viewModel.generateNumberImage(courses.size)
            }

            viewModel.imageNumbers.observe(viewLifecycleOwner){ imageNumbers ->
                for(i in courses.indices){
                    courses[i].image = imageNumbers[i]
                    adapterCourses.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onClick(course: Course) {
        viewModel.addCourseFavorites(course)
    }
}

