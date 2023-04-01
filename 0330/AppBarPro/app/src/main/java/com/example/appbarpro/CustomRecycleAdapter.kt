import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.appbarpro.DataList
import com.example.appbarpro.databinding.ItemViewBinding


class CustomRecycleAdapter(val dataList: MutableList<DataList>) : RecyclerView.Adapter<CustomRecycleAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }
    override fun getItemCount(): Int = dataList.size
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = holder.binding
        binding.tvName.text = dataList.get(position).tvName
        binding.tvAge.text = dataList.get(position).tvAge
        binding.tvEmail.text = dataList.get(position).tvEmail
        binding.ivPicture.setImageResource(dataList.get(position).ivPicture)
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${dataList.get(position).toString()}", Toast.LENGTH_SHORT).show()
        }
        binding.root.setOnLongClickListener {
            Toast.makeText(binding.root.context, "${binding.tvName.text} 삭제완료", Toast.LENGTH_SHORT).show()
            dataList.removeAt(position)
            notifyDataSetChanged()
            true
        }
    }
    class CustomViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root)
}