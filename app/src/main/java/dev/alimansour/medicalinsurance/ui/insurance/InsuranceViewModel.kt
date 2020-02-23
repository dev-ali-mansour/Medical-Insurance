package dev.alimansour.medicalinsurance.ui.insurance

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.alimansour.medicalinsurance.R
import dev.alimansour.medicalinsurance.model.Doctor

class InsuranceViewModel : ViewModel() {

    val companies = MutableLiveData<List<Doctor>>().apply {
        value = listOf(
            Doctor(R.drawable.medicare),
            Doctor(R.drawable.metlife),
            Doctor(R.drawable.axa),
            Doctor(R.drawable.allianz),
            Doctor(R.drawable.misrlife),
            Doctor(R.drawable.orient)
        )
    }
}