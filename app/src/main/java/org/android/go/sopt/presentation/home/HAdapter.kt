package org.android.go.sopt.presentation.home
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemTitleBinding

class HAdapter(context: Context) : RecyclerView.Adapter<HAdapter.HAdapterViewHolder>() {

    class HAdapterViewHolder(private val binding: ItemTitleBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HAdapterViewHolder {
        val binding = ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HAdapterViewHolder(binding)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: HAdapterViewHolder, position: Int) {
    }
}
