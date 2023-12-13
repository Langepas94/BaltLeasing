package com.example.baltleasing.destinations.MainScreen.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var data = MutableLiveData<String>()

    fun getData() {
        data.value = "Main viewModel works correctly"
    }
}