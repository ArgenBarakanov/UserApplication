package com.example.userapplication.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.userapplication.R
import com.example.userapplication.databinding.FragmentLoginBinding
import com.example.userapplication.viewmodel.UserViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.userViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.button.setOnClickListener { authenticate() }
        return binding.root
    }

    fun authenticate(){
        viewModel.authenticate(binding.nameInput.text.toString(), binding.passwordInput.text.toString())
        binding.nameInput.text?.clear()
        binding.passwordInput.text?.clear()
    }
}