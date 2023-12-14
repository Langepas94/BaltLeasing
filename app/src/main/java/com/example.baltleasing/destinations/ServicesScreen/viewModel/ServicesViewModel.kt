package com.example.baltleasing.destinations.ServicesScreen.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baltleasing.data.MockServicesScreen
import com.example.baltleasing.data.ServiceScreenModel

class ServicesViewModel: ViewModel() {
    var data = MutableLiveData<ServiceScreenModel>()
    fun getData() {
    data.value = MockServicesScreen.model
    }
}