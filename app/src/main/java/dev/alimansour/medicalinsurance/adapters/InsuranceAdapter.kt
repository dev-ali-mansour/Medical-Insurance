package dev.alimansour.medicalinsurance.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dev.alimansour.medicalinsurance.R
import dev.alimansour.medicalinsurance.databinding.InsuranceItemBinding
import dev.alimansour.medicalinsurance.model.Doctor

/**
 * MedicalInsurance Android Application
 * Copyright © 2016-2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ------------------- MedicalInsurance IS FREE SOFTWARE --------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class InsuranceAdapter(private val companies: List<Doctor>) :
    RecyclerView.Adapter<InsuranceAdapter.InsuranceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsuranceViewHolder {
        val binding: InsuranceItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.insurance_item, parent, false
        )
        return InsuranceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InsuranceViewHolder, position: Int) {
        holder.binding.companyViewImage.setImageResource(companies[position].image)
    }

    override fun getItemCount(): Int {
        return companies.size
    }

    inner class InsuranceViewHolder(val binding: InsuranceItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}