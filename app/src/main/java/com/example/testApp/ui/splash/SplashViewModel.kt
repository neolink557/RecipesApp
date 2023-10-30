package com.example.testApp.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _data = MutableLiveData<Boolean>()
    val data: LiveData<Boolean> = _data

    fun fetchData() {
        _data.value = true
    }
}
