package me.undownding.zhihu;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by undow on 2016/1/4.
 */
public class ZhihuApplication extends Application {

    private static ZhihuApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        sInstance = this;
    }

    public static ZhihuApplication getInstance() {
        return sInstance;
    }
}
