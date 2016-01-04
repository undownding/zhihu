package me.undownding.zhihu

import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.webkit.WebView
import butterknife.Bind
import butterknife.ButterKnife
import com.snappydb.DBFactory
import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout
import me.imid.swipebacklayout.lib.SwipeBackLayout
import me.imid.swipebacklayout.lib.app.SwipeBackActivity
import me.undownding.zhihu.api.ZhihuApi
import me.undownding.zhihu.model.Story
import retrofit.RestAdapter
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import kotlin.text.Regex
import kotlin.text.replace

/**
 * Created by undow on 2016/1/4.
 */
class StoryActivity: SwipeBackActivity() {

    @Bind(R.id.toolbar)
    lateinit  var toolbar: Toolbar

    @Bind(R.id.webview)
    lateinit var webView: WebView

    @Bind(R.id.main_swipe)
    lateinit var swipeRefreshLayout: WaveSwipeRefreshLayout

    var storyId: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        // Init SwipebackLayout
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT)

        // ButterKnife.bind(this)
        toolbar = ButterKnife.findById(this, R.id.toolbar)
        webView = ButterKnife.findById(this, R.id.webview)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        swipeRefreshLayout = ButterKnife.findById<WaveSwipeRefreshLayout>(this, R.id.main_swipe)

        swipeRefreshLayout.setWaveColor(resources.getColor(R.color.colorPrimary))
        swipeRefreshLayout.setColorSchemeColors(resources.getColor(android.R.color.white))
        swipeRefreshLayout.setOnRefreshListener {
            refresh()
        }

        storyId = intent.extras.getString("id")
        initWebView()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true;
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initWebView() {
        webView.settings.javaScriptEnabled = true;
        swipeRefreshLayout.isRefreshing = true

        // Load from NoSQL DB
        Observable.create<Story?> { observable ->
            try {
                if (storyId != null) {
                    val snappyDB = DBFactory.open(application)
                    val story = snappyDB.getObject(storyId, Story::class.java)
                    observable.onNext(story)
                    snappyDB.close()
                } else {
                    observable.onNext(null)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                observable.onNext(null)
            }
        }
        .observeOn(Schedulers.newThread())
        .subscribeOn(AndroidSchedulers.mainThread())
        .doOnError { err -> /* do nothing */ }
        .subscribe {
            story -> modelToView(story)
            refresh()
        }
    }

    private fun refresh() {
        if (storyId != null) {
            val api = RestAdapter.Builder().setEndpoint("http://news-at.zhihu.com/").build().create(ZhihuApi::class.java)
            api.getNews(newsId = storyId!!)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .doOnError {
                        err ->
                        swipeRefreshLayout.isRefreshing = false
                    }
                    .subscribe { story ->
                        modelToView(story)

                        Handler().postDelayed({
                            swipeRefreshLayout.isRefreshing = false
                        }, 1200)

                        // Save to DB
                        Thread() {
                            try {
                                val snappyDB = DBFactory.open(application)
                                snappyDB.put(storyId, story)
                                snappyDB.close()
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }.start()
                    }
        }
    }

    private fun modelToView(data: Story?) {
        if (data != null) {

            var htmlString = "<html><head>"
            for (css in data.css) {
                htmlString += "<link type=\"text/css\" rel=\"stylesheet\" href=\"$css\">"
            }
            htmlString += "</head><body>${data.body}</body></html>"
            val regex = Regex("<div class\\S+holder\\\">[\\s+]</div>")
            val regex2 = Regex("<div class\\S+holder\\\"></div>")
            htmlString = htmlString.replace(regex, "<img src=\"${data.image}\" width=\"100%\" />")
            htmlString = htmlString.replace(regex2, "<img src=\"${data.image}\" width=\"100%\"/>")

            webView.post({
                webView.loadData(htmlString, "text/html; charset=UTF-8", null);
            })
            runOnUiThread { supportActionBar?.title = data.title }
        }
    }

}