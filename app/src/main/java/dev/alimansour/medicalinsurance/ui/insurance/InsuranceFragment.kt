package dev.alimansour.medicalinsurance.ui.insurance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import dev.alimansour.medicalinsurance.R
import dev.alimansour.medicalinsurance.adapters.InsuranceAdapter
import dev.alimansour.medicalinsurance.databinding.FragmentInsuranceBinding

class InsuranceFragment : Fragment() {

    private lateinit var insuranceViewModel: InsuranceViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        insuranceViewModel = ViewModelProvider(this).get(InsuranceViewModel::class.java)
        val binding: FragmentInsuranceBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_insurance,
            container, false
        )
        initRecyclerView(binding)
        return binding.root
    }

    /**
     * Initializing RecyclerView to show insurance companies list for user
     * @param binding FragmentInsuranceBinding
     */
    private fun initRecyclerView(binding: FragmentInsuranceBinding) {
        try {
            binding.recyclerView.setHasFixedSize(true)
            binding.recyclerView.layoutManager =
                GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, true)

            // Retrieve data from viewModel
            insuranceViewModel.companies.observe(this, Observer {
                val insuranceAdapter = InsuranceAdapter(it)
                binding.recyclerView.adapter = insuranceAdapter
                insuranceAdapter.notifyDataSetChanged()
            })
        } catch (e: Exception) {
            Toast.makeText(
                context,
                "Error while loading companies data! ${e.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}