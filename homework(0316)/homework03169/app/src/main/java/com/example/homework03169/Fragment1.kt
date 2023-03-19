package com.example.homework03169

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework03169.databinding.Frag1Binding

class Fragment1: Fragment() {
    lateinit var binding : Frag1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      val view = inflater.inflate(R.layout.frag1, container, false)

        return view
    }
}