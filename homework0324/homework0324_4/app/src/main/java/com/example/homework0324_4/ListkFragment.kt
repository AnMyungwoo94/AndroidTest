package com.example.homework0324_4

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework0324_4.databinding.FragmentListkBinding

class ListkFragment : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var binding : FragmentListkBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textTitle.text = arguments?.getString("key1")
        binding.textvalue.text = "${arguments?.getInt("key2")}"

        binding.btnNext.setOnClickListener {
            mainActivity.goDetil()
        }
    }

    fun setValue(value: String){
        binding.textFromActivity.text = value
    }
}