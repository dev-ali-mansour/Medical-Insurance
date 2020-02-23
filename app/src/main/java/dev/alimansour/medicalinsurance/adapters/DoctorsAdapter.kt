package dev.alimansour.medicalinsurance.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dev.alimansour.medicalinsurance.R
import dev.alimansour.medicalinsurance.adapters.DoctorsAdapter.DoctorsViewHolder
import dev.alimansour.medicalinsurance.databinding.DoctorItemBinding
import dev.alimansour.medicalinsurance.model.Doctor

/**
 * MedicalInsurance Android Application
 * Copyright © 2016-2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ------------------- MedicalInsurance IS FREE SOFTWARE --------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class DoctorsAdapter(private val doctors: List<Doctor>) :
    RecyclerView.Adapter<DoctorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorsViewHolder {
        val binding: DoctorItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.doctor_item, parent, false
        )
        return DoctorsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoctorsViewHolder, position: Int) {
        holder.binding.doctorImageView.setImageResource(doctors[position].image)
    }

    override fun getItemCount(): Int {
        return doctors.size
    }

    inner class DoctorsViewHolder(val binding: DoctorItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}