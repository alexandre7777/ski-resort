package com.alexandre.skiresort.ui.skiresortlist

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alexandre.skiresort.Injection
import com.alexandre.skiresort.R

class SkiResortListActivity : AppCompatActivity() {

    private lateinit var viewModelSkiResortList: SkiResortListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelSkiResortList = ViewModelProviders.of(this, Injection.provideViewModelFactorySkiResortList(this))
                .get(SkiResortListViewModel::class.java)
    }
}
