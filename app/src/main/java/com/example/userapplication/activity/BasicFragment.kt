package com.example.userapplication.activity

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

open class BasicFragment: Fragment() {
    fun navigateToLoginFragment(destination: Int) {
       this.view?.findNavController()?.navigate(destination)
    }
}