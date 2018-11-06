package test.app.com.apptest.strategy_study;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.content.Context;
import android.widget.ImageView;

public class UniverseImageLoaderStrategy implements BaseImageLoaderStrategy {

     DisplayImageOptions options;

    public void initOptions(Context context){
        ImageLoaderConfiguration configuration=ImageLoaderConfiguration.createDefault(context);
        ImageLoader.getInstance().init(configuration);
        options=DisplayImageOptions.createSimple();
    }

    @Override
    public void loadImage(Context context, ImageView imageView, String url) {
        initOptions(context);
        ImageLoader.getInstance().displayImage(url,imageView,options);
    }
}
