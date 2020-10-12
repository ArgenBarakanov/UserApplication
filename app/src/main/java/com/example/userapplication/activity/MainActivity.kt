package com.example.userapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.userapplication.R
import com.example.userapplication.databinding.ActivityMainBinding
import com.example.userapplication.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.lifecycleOwner = this
        binding.mainActivityViewModel = viewModel

        binding.button.setOnClickListener {
            login()
        }
    }

    private fun login() {
        viewModel.login(binding.loginInput.text.toString(), binding.editTextTextPassword.text.toString())
        binding.loginInput.text?.clear()
        binding.editTextTextPassword.text?.clear()
    }

}