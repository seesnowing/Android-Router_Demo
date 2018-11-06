package test.app.com.apptest.strategy_study;

import com.bumptech.glide.Glide;

import android.content.Context;
import android.widget.ImageView;

public class GlideImageLoaderStategy implements BaseImageLoaderStrategy {
    @Override
    public void loadImage(Context context, ImageView imageView, String url) {
        Glide.with(context).load(url).into(imageView);
    }
}
