package org.android.go.sopt.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.android.go.sopt.data.remote.model.ResponseReqresDto
import org.android.go.sopt.databinding.ItemMemberBinding

class RVAdapter:ListAdapter<ResponseReqresDto.ReqresData,RVAdapter.RVViewHolder>(MemberDiffUtil()) {

    private val memberList: List<ResponseReqresDto.ReqresData> = emptyList()
    class RVViewHolder(private val binding:ItemMemberBinding ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseReqresDto.ReqresData) {
           with(binding){
               Glide.with(root)
                   .load(data.avatar)
                   .into(ivPhoto)
               tvName.text=data.first_name
               tvEmail.text=data.email
           }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val binding = ItemMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class MemberDiffUtil:DiffUtil.ItemCallback<ResponseReqresDto.ReqresData>(){
        override fun areItemsTheSame(oldItem: ResponseReqresDto.ReqresData, newItem: ResponseReqresDto.ReqresData): Boolean {
            return oldItem==newItem
        }
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: ResponseReqresDto.ReqresData, newItem: ResponseReqresDto.ReqresData): Boolean {
            return oldItem==newItem
        }
    }

}