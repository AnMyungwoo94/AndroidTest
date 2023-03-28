package com.example.activitylifecyclepro

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.activitylifecyclepro.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {
    lateinit var binding: FragmentTwoBinding
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity // mainActivity context 얻기
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater)
        binding.tvMessge2.text = this.arguments?.getString("name")

        binding.btnSend2.setOnClickListener {
            //1번한테 전달
            mainActivity.changeFragment("FRAG1",binding.edtMessage3.text.toString())
        }
        return binding.root
    }
}