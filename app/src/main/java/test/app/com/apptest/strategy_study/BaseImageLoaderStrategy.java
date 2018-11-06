package test.app.com.apptest.strategy_study;

import android.content.Context;
import android.widget.ImageView;

public interface BaseImageLoaderStrategy {
    /**
     *
     * @param context
     * @param imageView
     * @param url
     */
    void loadImage(Context context, ImageView imageView,String url);
}
