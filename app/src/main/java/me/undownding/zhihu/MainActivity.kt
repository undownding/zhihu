package me.undownding.zhihu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View

import butterknife.Bind
import butterknife.ButterKnife
import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout
import me.undownding.zhihu.api.ZhihuApi
import me.undownding.zhihu.binding.IndexAdapter
import me.undownding.zhihu.model.StoryList
import retrofit.RestAdapter
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1

class MainActivity : AppCompatActivity() {

    @Bind(R.id.toolbar)
    lateinit  var toolbar: Toolbar

    @Bind(R.id.recyclyer_view)
    lateinit var recyclerView: RecyclerView

    @Bind(R.id.main_swipe)
    lateinit var swipeRefreshLayout: WaveSwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Not work ???
        //        ButterKnife.bind(this)
        toolbar = ButterKnife.findById<Toolbar>(this, R.id.toolbar)
        recyclerView = ButterKnife.findById<RecyclerView>(this, R.id.recyclyer_view)
        swipeRefreshLayout = ButterKnife.findById<WaveSwipeRefreshLayout>(this, R.id.main_swipe)

        swipeRefreshLayout.setWaveColor(resources.getColor(R.color.colorPrimary))
        swipeRefreshLayout.setColorSchemeColors(resources.getColor(android.R.color.white))
        swipeRefreshLayout.setOnRefreshListener {
            refresh()
        }

        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        initRecyclerView(recyclerView)
    }


    fun initRecyclerView(recyclerView: RecyclerView) {
        val layoutManager = LinearLayoutManager(ZhihuApplication.getInstance())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        refresh()
    }

    fun refresh() {
        val api = RestAdapter.Builder().setEndpoint("http://news-at.zhihu.com/").build().create(ZhihuApi::class.java)
        api.getLast()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    err ->
                    // do nothing with err
                }
                .subscribe { storyList ->
                    val adapter = IndexAdapter(storyList)
                    recyclerView.adapter = adapter
                    swipeRefreshLayout.isRefreshing = false
                }
    }

    public fun onClick(view: View) {
        // do nothing
    }
}
