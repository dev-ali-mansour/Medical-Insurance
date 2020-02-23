package dev.alimansour.medicalinsurance.model

import android.content.Context
import android.net.ConnectivityManager

/**
 * MedicalInsurance Android Application
 * Copyright © 2016-2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ------------------- MedicalInsurance IS FREE SOFTWARE --------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class Network(private val context: Context) {

    /**
     * Check if user device is connected to internet or not
     */
    fun isConnected(): Boolean = try {
        val cm = (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
        val activeNetwork = cm.activeNetworkInfo
        activeNetwork != null && activeNetwork.isConnectedOrConnecting
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}