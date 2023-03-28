package com.example.activitylifecyclepro

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.activitylifecyclepro.databinding.FragmentThreeBinding

class ThreeFragment : Fragment() {

    lateinit var binding: FragmentThreeBinding
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeBinding.inflate(inflater)

        binding.ivPicture3.setOnClickListener {
            //2번한테 전달
            mainActivity.changeFragment("FRAG2",binding.tvMessge3.text.toString())
        }
        return binding.root
    }
}