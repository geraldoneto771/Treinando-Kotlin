package com.example.apptreinando

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.apptreinando.databinding.CreatePointUI


class createPoint : Fragment() {

    private lateinit var binding: CreatePointUI

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = CreatePointUI.inflate(inflater)


        binding.comprovativo.setOnClickListener{
            if(binding.comprovativo.isChecked()){
                binding.create.visibility = View.VISIBLE
            } else{
                binding.create.visibility = View.GONE
            }
        }


        return binding.root
    }

}