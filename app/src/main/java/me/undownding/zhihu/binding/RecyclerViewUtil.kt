package me.undownding.zhihu.binding

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import me.undownding.zhihu.ZhihuApplication
import me.undownding.zhihu.api.ZhihuApi
import retrofit.RestAdapter
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by undow on 2016/1/4.
 */
public class RecyclerViewUtil {
    companion object {
        fun initRecyclerView(recyclerView: RecyclerView) {
            val layoutManager = LinearLayoutManager(ZhihuApplication.getInstance())
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = layoutManager


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
                    }

        }
    }
}