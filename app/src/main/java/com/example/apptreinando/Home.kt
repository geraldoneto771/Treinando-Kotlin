package com.example.apptreinando

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.apptreinando.databinding.FragmentHomeBinding

class Home : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentHomeBinding.inflate(inflater)

        mBinding.fab.setOnClickListener {
            findNavController().navigate(HomeDirections.actionHomeToRegistre())
        }

        return mBinding.root
    }

}