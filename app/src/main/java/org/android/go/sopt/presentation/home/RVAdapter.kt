package org.android.go.sopt.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.android.go.sopt.data.remote.response.ResponseReqresDto
import org.android.go.sopt.databinding.ItemMemberBinding

class RVAdapter :
    ListAdapter<ResponseReqresDto.ReqresData, RVAdapter.RVViewHolder>(MemberDiffUtil()) {

    class RVViewHolder(private val binding: ItemMemberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseReqresDto.ReqresData) {
            with(binding) {
                ivPhoto.load(data.avatar)
                tvName.text = data.first_name
                tvEmail.text = data.email
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

    class MemberDiffUtil : DiffUtil.ItemCallback<ResponseReqresDto.ReqresData>() {
        override fun areItemsTheSame(
            oldItem: ResponseReqresDto.ReqresData,
            newItem: ResponseReqresDto.ReqresData,
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ResponseReqresDto.ReqresData,
            newItem: ResponseReqresDto.ReqresData,
        ): Boolean {
            return oldItem == newItem
        }
    }
}
