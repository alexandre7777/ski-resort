package com.alexandre.skiresort.ui.skiresortlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.alexandre.skiresort.Injection
import com.alexandre.skiresort.R
import com.alexandre.skiresort.model.SkiResort
import kotlinx.android.synthetic.main.activity_ski_resort_list.*

class SkiResortListActivity : AppCompatActivity() {

    private lateinit var viewModelSkiResortList: SkiResortListViewModel

    private var adapter = SkiResortAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ski_resort_list)

        viewModelSkiResortList = ViewModelProviders.of(this, Injection.provideViewModelFactorySkiResortList(this))
                .get(SkiResortListViewModel::class.java)

        initAdapter()
    }

    private fun initAdapter(){
        list.layoutManager = LinearLayoutManager(applicationContext)
        list.adapter = adapter

        /**
         * Observe changes in the list of ski resort
         */
        viewModelSkiResortList.skiResortList.observe(this, Observer<List<SkiResort>> {
            adapter.submitList(it)
        })
    }
}
