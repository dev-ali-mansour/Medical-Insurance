package dev.alimansour.medicalinsurance

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.alimansour.medicalinsurance.databinding.ActivityMainBinding
import dev.alimansour.medicalinsurance.model.Network

/**
 * MedicalInsurance Android Application
 * Copyright © 2016-2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ------------------- MedicalInsurance IS FREE SOFTWARE --------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val network = Network(this)
        val navView: BottomNavigationView = binding.navView

        // Notify user if device is not connected to the internet
        if (!network.isConnected()) {
            Toast.makeText(this, "You are not connected to Internet", Toast.LENGTH_LONG).show()
        }
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_insurance, R.id.navigation_chat
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
