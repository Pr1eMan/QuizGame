package com.ifk8edvmat1gabkojginkir.ktuprojektas.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "nustatymai"
    }
    val text: LiveData<String> = _text
}