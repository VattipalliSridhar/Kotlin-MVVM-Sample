package com.apps.kotlinmvvm.view.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.apps.kotlinmvvm.R
import com.apps.kotlinmvvm.databinding.FragmentHomeBinding
import com.apps.kotlinmvvm.databinding.FragmentSampleBinding


class SampleFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentSampleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sample, container, false)


        return binding.root
    }


}