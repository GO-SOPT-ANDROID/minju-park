package org.android.go.sopt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.Data.RVData
import org.android.go.sopt.databinding.ItemSongBinding

class RVAdapter (context: Context): RecyclerView.Adapter<RVAdapter.RVViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var itemList: List<RVData> = emptyList()

    class RVViewHolder(private val binding: ItemSongBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: RVData) {
            binding.ivPhoto.setImageDrawable(binding.root.context.getDrawable(data.image))
            binding.tvTitle.text = data.song
            binding.tvSinger.text = data.singer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val binding = ItemSongBinding.inflate(inflater, parent, false)
        return RVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount():Int{
        return itemList.size
    }

    fun setItemList(itemList: List<RVData>){
        this.itemList = itemList.toList()
        notifyDataSetChanged()
    }
}