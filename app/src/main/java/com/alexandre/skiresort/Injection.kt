package com.alexandre.skiresort

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.alexandre.skiresort.data.SkiResortRepo
import com.alexandre.skiresort.db.SkiResortDatabase
import com.alexandre.skiresort.service.SkiResortListService
import com.alexandre.skiresort.ui.skiresortlist.ViewModelFactorySkiResortList
import java.util.concurrent.Executors

object Injection{

    private fun provideSkiResortRepo(context: Context): SkiResortRepo {
        val database = SkiResortDatabase.getInstance(context)
        return SkiResortRepo(SkiResortListService.create(), database.skiResortDao(), Executors.newSingleThreadExecutor())
    }

    fun provideViewModelFactorySkiResortList(context: Context): ViewModelProvider.Factory {
        return ViewModelFactorySkiResortList(provideSkiResortRepo(context))
    }
}