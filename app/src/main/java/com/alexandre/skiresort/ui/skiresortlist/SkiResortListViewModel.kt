package com.alexandre.skiresort.ui.skiresortlist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.alexandre.skiresort.data.SkiResortRepo
import com.alexandre.skiresort.model.SkiResort

class SkiResortListViewModel(private val skiResortRepo: SkiResortRepo) : ViewModel() {

    //list of all the ski resorts
    val skiResortList : LiveData<List<SkiResort>> = skiResortRepo.getAllSkiResorts()
}