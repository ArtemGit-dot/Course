package com.example.coursesapplication.presentation.mainactivity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.coursesapplication.databinding.FragmentLoginBinding
import com.example.coursesapplication.presentation.mainmenu.MainMenu

class Login : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var viewModel: LoginFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[LoginFragmentViewModel :: class.java]

        binding.bnLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            viewModel.isEmailValid(email)
            }

        viewModel.emailValid.observe(viewLifecycleOwner){
            if(it == true && binding.editTextPassword.text.toString().isNotEmpty()){
                val intent = Intent(context, MainMenu::class.java)
                startActivity(intent)
                activity?.finish()
            }
            else {
                Toast.makeText(context, "Неверный Email или пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }
}