package com.example.baltleasing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.baltleasing.databinding.FragmentServicesBinding
import com.example.baltleasing.destinations.ServicesScreen.viewModel.ServicesViewModel

class ServicesFragment : Fragment() {

    private val viewModel: ServicesViewModel by activityViewModels()

    private lateinit var binding: FragmentServicesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentServicesBinding.inflate(layoutInflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       viewModelBind()
        viewModel.getData()
    }

    private fun viewModelBind() {
        viewModel.data.observe(activity as LifecycleOwner, {
            binding.mainTextServices.text = it
        })
    }

}