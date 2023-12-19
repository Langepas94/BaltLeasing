package com.example.baltleasing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.baltleasing.databinding.FragmentMainBinding
import com.example.baltleasing.destinations.mainScreen.viewModel.MainViewModel

class MainFragment : Fragment() {

    private  lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       viewModelBind()
        viewModel.getData()
    }

    private  fun viewModelBind() {
        viewModel.data.observe(activity as LifecycleOwner, Observer {
            binding.mainText.text = it
        })

    }
}