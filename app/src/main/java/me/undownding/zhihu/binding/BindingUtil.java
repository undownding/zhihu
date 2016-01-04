package me.undownding.zhihu.binding;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

import me.undownding.zhihu.StoryActivity;
import me.undownding.zhihu.ZhihuApplication;
import me.undownding.zhihu.model.StoryList;


/**
 * Created by undow on 2016/1/4.
 */
public class BindingUtil {

    @BindingAdapter("binding:image_url")
    public static void bindImage(SimpleDraweeView view, Object[] url) {
        if (url.length > 0) {
            if (url[0].toString().startsWith("//")) {
                url[0] = "http:" + url[0];
            }

            view.setImageURI(Uri.parse(url[0].toString()));
        }
    }

    @BindingAdapter("binding:bind_click")
    public static void bindClick(View view, final StoryList.Story story) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZhihuApplication.getInstance(), StoryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle extra = new Bundle();
                extra.putString("id", String.valueOf(story.getId()));
                intent.putExtras(extra);
                ZhihuApplication.getInstance().startActivity(intent);
            }
        });
    }

}
