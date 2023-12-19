package com.example.baltleasing.destinations.servicesScreen.view

import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.baltleasing.data.ServiceDataModel
import com.example.baltleasing.databinding.FragmentServicesBinding
import com.example.baltleasing.destinations.servicesScreen.adapter.ServiceRecyclerAdapter
import com.example.baltleasing.destinations.servicesScreen.adapter.decoration.ServiceAdapterDecoration
import com.example.baltleasing.destinations.servicesScreen.viewModel.ServicesViewModel

class ServicesFragment : Fragment() {

    private val viewModel: ServicesViewModel by viewModels()
    private lateinit var binding: FragmentServicesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentServicesBinding.inflate(layoutInflater, container, false)
        binding.servicesRecyclerView.addItemDecoration(ServiceAdapterDecoration(6f, requireContext()))
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       viewModelBind()
    }

    private fun viewModelBind() {
        val itemList: Array<ServiceDataModel> = viewModel.getArray()
        val adapter = ServiceRecyclerAdapter(itemList, screenSizer())
        binding.servicesRecyclerView.adapter = adapter
    }

    private fun screenSizer(): DisplayMetrics {
        return Resources.getSystem().displayMetrics
    }
}