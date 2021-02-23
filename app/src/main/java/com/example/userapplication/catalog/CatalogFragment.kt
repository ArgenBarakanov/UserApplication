package com.example.userapplication.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.userapplication.R
import com.example.userapplication.databinding.FragmentCatalogBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CatalogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CatalogFragment : Fragment() {
    private lateinit var binding: FragmentCatalogBinding
    private val viewModel: CatalogViewModel by lazy {
        ViewModelProvider(requireActivity()).get(CatalogViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_catalog, container, false)
        val adapter = CatalogAdapter(viewModel)
        binding.lifecycleOwner = this
        binding.catalogList.adapter = adapter
        viewModel.categories.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })
        viewModel.selectedProduct.observe(viewLifecycleOwner, Observer {
            if(it != null) {
           this.findNavController().navigate(CatalogFragmentDirections.actionCatalogFragmentToProductFragment(it))
            viewModel.unSelectDisplayedProduct()
            }
        })
        return binding.root
    }


}