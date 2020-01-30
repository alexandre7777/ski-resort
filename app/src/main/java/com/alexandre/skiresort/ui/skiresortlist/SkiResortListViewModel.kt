package com.alexandre.skiresort.ui.skiresortlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alexandre.skiresort.data.SkiResortRepo
import com.alexandre.skiresort.model.SkiResort

class SkiResortListViewModel(skiResortRepo: SkiResortRepo) : ViewModel() {

    //list of all the ski resorts
    val skiResortList : LiveData<List<SkiResort>> = skiResortRepo.getAllSkiResorts()
}