package com.ifk8edvmat1gabkojginkir.ktuprojektas.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "START"
    }
    val text: LiveData<String> = _text
}