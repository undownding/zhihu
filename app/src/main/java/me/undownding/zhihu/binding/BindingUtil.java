package me.undownding.zhihu.binding;

import android.databinding.BindingAdapter;
import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by undow on 2016/1/4.
 */
public class BindingUtil {
    @BindingAdapter("binding:image_url")
    public static void bindImage(SimpleDraweeView view, String[] url) {
        if (url.length > 0) {
            if (url[0].startsWith("//")) {
                url[0] = "http:" + url[0];
            }

            view.setImageURI(Uri.parse(url[0]));
        }
    }
}
