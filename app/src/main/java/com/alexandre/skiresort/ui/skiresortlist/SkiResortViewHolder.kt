package com.alexandre.skiresort.ui.skiresortlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alexandre.skiresort.R
import com.alexandre.skiresort.model.SkiResort

class SkiResortViewHolder(view: View)  : RecyclerView.ViewHolder(view) {
    private val skiResortName: TextView = view.findViewById(R.id.skiResortName)
    private val skiResortCountry: TextView = view.findViewById(R.id.skiResortCountry)
    private val skiResortMountain: TextView = view.findViewById(R.id.skiResortMountain)
    private val skiResortSlopesKm: TextView = view.findViewById(R.id.skiResortSlopesKm)
    private val skiResortLifts: TextView = view.findViewById(R.id.skiResortLifts)
    private val skiResortSlopes: TextView = view.findViewById(R.id.skiResortSlopes)

    fun bind(skiResort: SkiResort?) {
        if (skiResort != null) {
            showSkiResortData(skiResort)
        }
    }

    private fun showSkiResortData(skiResort: SkiResort) {
        skiResort.apply {
            skiResortName.text = name
            skiResortCountry.text = country
            skiResortMountain.text = mountainRange
            skiResortSlopesKm.text = slopeKm.toString()
            skiResortLifts.text = lifts.toString()
            skiResortSlopes.text = slopes.toString()
        }
    }

    companion object {
        fun create(parent: ViewGroup): SkiResortViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.ski_resort_item, parent, false)
            return SkiResortViewHolder(view)
        }
    }
}