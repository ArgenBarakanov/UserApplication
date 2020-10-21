package com.example.userapplication.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.userapplication.R
import com.example.userapplication.databinding.FragmentGalleryBinding
import com.example.userapplication.viewmodel.GalleryViewModel
import com.example.userapplication.viewmodel.UserViewModel


class GalleryFragment : BasicFragment(){
    private lateinit var viewModel: UserViewModel
    private lateinit var binding: FragmentGalleryBinding
    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery, container, false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        binding.galleryViewModel = galleryViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        // Inflate the layout for this fragment
        return binding.root
    }
}