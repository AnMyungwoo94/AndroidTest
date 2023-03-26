package com.example.homework0324_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.example.homework0324_5.databinding.FragmentReciverBinding

class ReciverFragment : Fragment() {
    lateinit var binding:FragmentReciverBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReciverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("request"){ requestKey, bundle ->
            bundle.getString("senderKey")?.let { value ->
                binding.textView.text = value
            }
        }
    }
}