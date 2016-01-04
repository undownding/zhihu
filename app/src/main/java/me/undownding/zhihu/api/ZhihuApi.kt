package me.undownding.zhihu.api

import me.undownding.zhihu.model.*
import retrofit.http.GET
import retrofit.http.Path
import rx.Observable

/**
 * Created by undow on 2016/1/4.
 */
public interface  ZhihuApi {

    @GET("/api/{api_version}/news/latest")
    fun getLast(@Path("api_version") apiVersion: Int = API_VERSION): Observable<StoryList>

    @GET("/api/{api_version}/news/{news_id}")
    fun getNews(@Path("api_version") apiVersion: Int = API_VERSION, @Path("news_id") newsId: String = "3892357"): Observable<Story>

    @GET("/api/{api_version}/news/before/{date}")
    fun getHistory(@Path("api_version") apiVersion: Int = API_VERSION, @Path("date") date: String = "20131119"): Observable<StoryList>

    @GET("/api/{api_version}/story-extra/{story_id}")
    fun getExtra(@Path("api_version") apiVersion: Int = API_VERSION, @Path("story_id") storyId: String = "3892357"): Observable<StoryExtra>

    @GET("/api/{api_version}/story/{story_id}/long-comments")
    fun getLongComments(@Path("api_version") apiVersion: Int = API_VERSION, @Path("story_id") storyId: String = "3892357"): Observable<LongComments>

    @GET("/api/{api_version}/story/{story_id}/short-comments")
    fun getShortComments(@Path("api_version") apiVersion: Int = API_VERSION, @Path("story_id") storyId: String = "3892357"): Observable<ShortComments>

    @GET("/api/{api_version}/themes")
    fun getThemes(@Path("api_version") apiVersion: Int = API_VERSION): Observable<Themes>

    @GET("/api/4/theme/{theme_id}")
    fun getTheme(@Path("api_version") apiVersion: Int = API_VERSION, @Path("theme_id") themeId: String = "11"): Observable<Theme>

    companion object {
        val API_VERSION: Int = 4
    }
}