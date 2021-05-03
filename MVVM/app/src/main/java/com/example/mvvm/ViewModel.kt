package com.example.mvvm

import androidx.lifecycle.ViewModel

class MainViewModel(lastValue: Int) : ViewModel() {
    var counter = lastValue
}