package com.example.activitylifecyclepro

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.activitylifecyclepro.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    lateinit var binding: FragmentOneBinding
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity // mainActivity context 얻기
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater)
        binding.tvMessge.text = this.arguments?.getString("name")

        binding.btnSend1.setOnClickListener {
            //2번한테 전달
            mainActivity.changeFragment("FRAG2",binding.edtMessage1.text.toString())
        }
        return binding.root
    }
}