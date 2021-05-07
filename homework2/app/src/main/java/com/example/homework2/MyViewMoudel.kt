package com.example.homework2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewMoudel: ViewModel() {
    val ballList = MutableLiveData<List<Balls>>() //data source as LiveData

    init{
        val ballListSource = ArrayList<Balls>()
            ballListSource.add("Baseball", R.drawable.baseball)
            ballListSource.add("Basketball", R.drawable.basketball)
            ballListSource.add("Football", R.drawable.football)
            ballListSource.add("Other", R.drawable.other)
        }
    }
    ballList.value = ballListSource
}