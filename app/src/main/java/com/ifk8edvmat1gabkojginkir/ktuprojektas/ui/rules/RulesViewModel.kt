package com.ifk8edvmat1gabkojginkir.ktuprojektas.ui.rules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RulesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "To answer a you need to click on the rectangle from the predefined options.\n" +
                "If you click the wrong answer, your total high-score will be reduced.\n" +
                "After the Quiz has been completed, overall results will be shown with your current ranking." +
                "To answer a you need to click on the rectangle from the predefined options.\n" +
                "If you click the wrong answer, your total high-score will be reduced.\n" +
                "After the Quiz has been completed, overall results will be shown with your current ranking." +
                "To answer a you need to click on the rectangle from the predefined options.\n" +
                "If you click the wrong answer, your total high-score will be reduced.\n" +
                "After the Quiz has been completed, overall results will be shown with your current ranking." +
                "To answer a you need to click on the rectangle from the predefined options.\n" +
                "If you click the wrong answer, your total high-score will be reduced.\n" +
                "After the Quiz has been completed, overall results will be shown with your current ranking." +
                "To answer a you need to click on the rectangle from the predefined options.\n" +
                "If you click the wrong answer, your total high-score will be reduced.\n" +
                "After the Quiz has been completed, overall results will be shown with your current ranking."
    }
    val text: LiveData<String> = _text
}