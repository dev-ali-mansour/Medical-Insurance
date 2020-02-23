package dev.alimansour.medicalinsurance.ui.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.alimansour.medicalinsurance.R
import dev.alimansour.medicalinsurance.model.Doctor

/**
 * MedicalInsurance Android Application
 * Copyright © 2016-2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ------------------- MedicalInsurance IS FREE SOFTWARE --------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ChatViewModel : ViewModel() {

    val doctors = MutableLiveData<List<Doctor>>().apply {
        value = listOf(
            Doctor(R.drawable.doctor_1),
            Doctor(R.drawable.doctor_2),
            Doctor(R.drawable.doctor_3),
            Doctor(R.drawable.doctor_4)
        )
    }
}