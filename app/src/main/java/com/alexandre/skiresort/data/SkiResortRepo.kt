package com.alexandre.skiresort.data

import android.arch.lifecycle.LiveData
import com.alexandre.skiresort.db.SkiResortDao
import com.alexandre.skiresort.model.SkiResort
import com.alexandre.skiresort.service.SkiResortListService
import com.alexandre.skiresort.service.requestSkiResort
import java.util.concurrent.Executor

class SkiResortRepo(private val skiResortListService: SkiResortListService, private val skiResortDao: SkiResortDao, private val ioExecutor: Executor) {

    fun getAllSkiResorts(): LiveData<List<SkiResort>> {
        requestSkiResort(skiResortListService, {
            skiResorts ->
            ioExecutor.execute {
                skiResortDao.insertAll(skiResorts)
            }
        }, { error ->

        })
        return skiResortDao.getAllSkiResorts()
    }
}
