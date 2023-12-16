package com.example.baltleasing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.baltleasing.data.ServiceDataModel
import com.example.baltleasing.databinding.FragmentServicesBinding
import com.example.baltleasing.destinations.ServicesScreen.adapter.ServiceRecyclerAdapter
import com.example.baltleasing.destinations.ServicesScreen.adapter.decoration.ServiceAdapterDecoration
import com.example.baltleasing.destinations.ServicesScreen.viewModel.ServicesViewModel

class ServicesFragment : Fragment() {

    private val viewModel: ServicesViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentServicesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentServicesBinding.inflate(layoutInflater, container, false)
        recyclerView = binding.servicesRecyclerView
        recyclerView.addItemDecoration(ServiceAdapterDecoration(12f, requireContext()))
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       viewModelBind()
    }

    private fun viewModelBind() {
        val itemList: Array<ServiceDataModel> = viewModel.getArray()
        val adapter = ServiceRecyclerAdapter(itemList)
        recyclerView.adapter = adapter
    }
}