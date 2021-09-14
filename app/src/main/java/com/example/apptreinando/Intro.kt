package com.example.apptreinando

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.apptreinando.databinding.FragmentIntroBinding


class Intro : Fragment() {

    private lateinit var mBinding: FragmentIntroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentIntroBinding.inflate(inflater)

        mBinding.buttonIntro.setOnClickListener {
            findNavController().navigate(IntroDirections.actionIntroToHome())
        }


        return mBinding.root

    }

}