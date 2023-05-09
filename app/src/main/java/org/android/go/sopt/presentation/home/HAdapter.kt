package org.android.go.sopt.presentation.home
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemTitleBinding

class HAdapter (context: Context): RecyclerView.Adapter<HAdapter.HAdapterViewHolder>() {

    class HAdapterViewHolder(private val binding: ItemTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
    //viewHolder에 들어갈 View를 만들어주는 함수 / 전체 Recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HAdapterViewHolder {
        val binding = ItemTitleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HAdapterViewHolder(binding)
    }

    //데이터 리스트의 아이템 갯수
    override fun getItemCount() = 1

    //각각의 ViewHolder에 데이터를 매칭하는 함수
    override fun onBindViewHolder(holder: HAdapterViewHolder, position: Int) {
    }
}