package com.alexandre.skiresort.ui.skiresortlist

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexandre.skiresort.model.SkiResort

class SkiResortAdapter : ListAdapter<SkiResort, RecyclerView.ViewHolder>(SKI_RESORT_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SkiResortViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as SkiResortViewHolder).bind(repoItem)
        }
    }


    companion object {
        private val SKI_RESORT_COMPARATOR = object : DiffUtil.ItemCallback<SkiResort>() {
            override fun areItemsTheSame(oldItem: SkiResort, newItem: SkiResort): Boolean =
                    oldItem.skiResortId == newItem.skiResortId

            override fun areContentsTheSame(oldItem: SkiResort, newItem: SkiResort): Boolean =
                    oldItem == newItem
        }
    }
}