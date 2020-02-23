package dev.alimansour.medicalinsurance.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import dev.alimansour.medicalinsurance.R
import dev.alimansour.medicalinsurance.adapters.DoctorsAdapter
import dev.alimansour.medicalinsurance.databinding.FragmentChatBinding

/**
 * MedicalInsurance Android Application
 * Copyright © 2016-2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ------------------- MedicalInsurance IS FREE SOFTWARE --------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ChatFragment : Fragment() {
    private lateinit var chatViewModel: ChatViewModel
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentChatBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_chat,
            container, false
        )
        viewPager = binding.doctorsViewpager
        chatViewModel = ViewModelProvider(this).get(ChatViewModel::class.java)
        initViewPager(binding)
        return binding.root
    }

    /**
     * Initialize ViewPager to view doctors list to user
     * @param binding FragmentChatBinding
     */
    private fun initViewPager(binding: FragmentChatBinding) {
        try {
            chatViewModel.doctors.observe(this, Observer {
                viewPager.adapter = DoctorsAdapter(it)
                binding.previousImageButton.setOnClickListener {
                    // Replace the current item with the previous one
                    viewPager.currentItem -= 1
                }
                binding.nextImageButton.setOnClickListener {
                    // Replace the current item with the next one
                    viewPager.currentItem += 1
                }
            })
        } catch (e: Exception) {
            Toast.makeText(
                context,
                "Error while loading doctors data! ${e.message}",
                Toast.LENGTH_LONG
            ).show()
            e.printStackTrace()
        }
    }
}