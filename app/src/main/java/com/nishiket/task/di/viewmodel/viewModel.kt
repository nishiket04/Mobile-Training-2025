package com.nishiket.task.di.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nishiket.task.di.repository.repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class viewModel @Inject constructor(private val repo: repository) : ViewModel() {
    private val liveData = MutableLiveData<String>()
    fun getData() {
        liveData.value = repo.getData() // gets the data from repo
    }

    fun getLiveData(): MutableLiveData<String> {
        return liveData // return live data
    }
}