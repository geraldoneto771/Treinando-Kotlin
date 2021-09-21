package com.example.apptreinando

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.get
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.apptreinando.databinding.CreatePointUI


class createPoint : Fragment() {

    private lateinit var binding: CreatePointUI
    var radiogroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = CreatePointUI.inflate(inflater)

        radiogroup = binding.photoSide

        binding.comprovativo.setOnClickListener{

            binding.create.visibility = View.VISIBLE
        }

        binding.exclusivo.setOnClickListener{

            binding.create.visibility = View.GONE
        }


        return binding.root
    }

}