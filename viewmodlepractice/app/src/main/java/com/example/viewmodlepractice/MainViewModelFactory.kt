package com.example.viewmodlepractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val lastValue: Int): ViewModelProvider.Factory {
    override fun<T: ViewModel?>create(modelVlass: Class<T>): T{
        return MainViewModel(lastValue) as T
    }
}