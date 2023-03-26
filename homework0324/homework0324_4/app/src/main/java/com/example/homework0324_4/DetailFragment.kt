package com.example.homework0324_4

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework0324_4.databinding.FragmentDetail2Binding
import com.example.homework0324_4.databinding.FragmentListkBinding

class DetailFragment : Fragment() {

    lateinit var mainActivity: MainActivity
    lateinit var binding : FragmentDetail2Binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentDetail2Binding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      binding.btnBack.setOnClickListener {
            mainActivity.goBack()
        }
    }
}