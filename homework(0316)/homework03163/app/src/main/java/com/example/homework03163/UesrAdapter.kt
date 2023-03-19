package com.example.homework03163

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UesrAdapter (val context: Context, val UesrList : ArrayList<User>): BaseAdapter() {

    override fun getCount(): Int {
        return UesrList.size
    }

    override fun getItem(position: Int): Any {
    return UesrList[position]
    }

    override fun getItemId(position: Int): Long {
    return 0
    }

    override fun getView(position: Int, converView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null)

        val profile = view.findViewById<ImageView>(R.id.iv_profile)
        val name = view.findViewById<TextView>(R.id.tv_name)
        val age = view.findViewById<TextView>(R.id.tv_age)
        val greet = view.findViewById<TextView>(R.id.tv_greet)

        val user = UesrList[position]

        profile.setImageResource(user.profile)
        name.text = user.name
        age.text = user.age
        greet.text = user.greet

        return view

    }

}