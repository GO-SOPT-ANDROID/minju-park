package org.android.go.sopt.presentation.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.data.music
import org.android.go.sopt.databinding.ItemSongBinding

class RVAdapter (context: Context): ListAdapter<music, RVAdapter.RVViewHolder>(MusicDiffUtil()) {
    private val inflater by lazy { LayoutInflater.from(context) }
    private val itemList: List<music> = emptyList()
    class RVViewHolder(private val binding: ItemSongBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: music) {
            binding.ivPhoto.setImageDrawable(binding.root.context.getDrawable(data.image))
            binding.tvTitle.text = data.song
            binding.tvSinger.text = data.singer
        }
    }

    //viewHolder에 들어갈 View를 만들어주는 함수 / 전체 Recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val binding = ItemSongBinding.inflate(inflater, parent, false)
        return RVViewHolder(binding)
    }

    //각각의 ViewHolder에 데이터를 매칭하는 함수
    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

/*
    //데이터 리스트의 아이템 갯수 리턴 -> itemList의 갯수
    override fun getItemCount():Int{
        return itemList.size
    }
    fun setItemList(itemList: List<RVData>){
        this.itemList = itemList.toList()
        notifyDataSetChanged()
    }
*/


    class MusicDiffUtil:DiffUtil.ItemCallback<music>(){
        override fun areItemsTheSame(oldItem: music, newItem: music): Boolean {
            return oldItem.song==newItem.song
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: music, newItem: music): Boolean {
            return oldItem==newItem
        }
    }



}