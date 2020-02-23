package dev.alimansour.medicalinsurance.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to our medical insurance app\n\n" +
                "With our app You can choose your preferred insurance company\n\n" +
                "You also can chat with our most professional doctors"
    }
    val text: LiveData<String> = _text
}