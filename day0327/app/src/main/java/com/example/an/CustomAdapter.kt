package com.example.an

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.an.databinding.ItemviewBinding

//3. CustomAdapter 설계하기
class CustomAdapter(val dataList: MutableList<DataList>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    //lateinit var context: Context 토스트 1번 방법
    //6. 아이템뷰 객체화 시킨다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemViewbinding: ItemviewBinding = ItemviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //context = parent.context 토스트 1번 방법
        return CustomViewHolder(itemViewbinding)
    }
    //5. 데이터리스트 사이즈설정
    override fun getItemCount(): Int = dataList.size
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemViewbinding = (holder as CustomViewHolder).itemViewbinding
        itemViewbinding.tvName.text = dataList.get(position).tvName
        itemViewbinding.tvAge.text = dataList.get(position).tvAge
        itemViewbinding.tvEmail.text = dataList.get(position).tvEmail
        itemViewbinding.ivPicture.setImageResource(dataList.get(position).ivPicture)
        itemViewbinding.root.setOnClickListener {
            //Log.e("CustomAdapter","${itemViewbinding.tvName.text}")
            Toast.makeText(itemViewbinding.root.context,"${itemViewbinding.tvName.text}", Toast.LENGTH_SHORT).show()
        }
    }
    //4. 뷰홀더 집기 위해서 내부클래스를 만든다.
    class CustomViewHolder(val itemViewbinding: ItemviewBinding): RecyclerView.ViewHolder(itemViewbinding.root)
}