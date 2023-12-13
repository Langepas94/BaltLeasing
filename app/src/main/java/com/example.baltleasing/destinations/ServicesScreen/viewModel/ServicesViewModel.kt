package com.example.baltleasing.destinations.ServicesScreen.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ServicesViewModel: ViewModel() {
    var data = MutableLiveData<String>()

    fun getData() {
        data.value = "ViewModel works correctly"
    }
}