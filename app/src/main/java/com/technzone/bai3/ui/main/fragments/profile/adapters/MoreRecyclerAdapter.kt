package com.technzone.bai3.ui.main.fragments.profile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technzone.bai3.data.models.profile.More
import com.technzone.bai3.databinding.RowMoreItemBinding
import com.technzone.bai3.ui.base.adapters.BaseBindingRecyclerViewAdapter
import com.technzone.bai3.ui.base.adapters.BaseViewHolder

class MoreRecyclerAdapter constructor(
    context: Context
) : BaseBindingRecyclerViewAdapter<More>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NormalViewHolder(
            RowMoreItemBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NormalViewHolder) {
            holder.bind(items[position])
        }
    }

    inner class NormalViewHolder(private val binding: RowMoreItemBinding) :
        BaseViewHolder<More>(binding.root) {
        override fun bind(item: More) {
            binding.data = item
            binding.root.setOnClickListener {
                itemClickListener?.onItemClick(binding.root, bindingAdapterPosition, item)
            }
        }
    }
}