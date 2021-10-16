package com.ifk8edvmat1gabkojginkir.ktuprojektas.ui.home

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ifk8edvmat1gabkojginkir.ktuprojektas.QuizMainActivty
import com.ifk8edvmat1gabkojginkir.ktuprojektas.R

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "START"
    }
    val text: LiveData<String> = _text

}