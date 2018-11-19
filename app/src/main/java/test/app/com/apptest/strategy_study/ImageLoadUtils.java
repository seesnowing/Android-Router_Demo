package test.app.com.apptest.strategy_study;

import android.content.Context;
import android.widget.ImageView;

public class ImageLoadUtils {

    private static ImageLoadUtils instance;
    private BaseImageLoaderStrategy baseImageLoaderStrategy;
    public static ImageLoadUtils getInstance(){
        if(instance==null) {
            instance = new ImageLoadUtils();
        }
        return instance;
    }

    public ImageLoadUtils setBaseImageLoaderStrategy(BaseImageLoaderStrategy baseImageLoaderStrategy) {
        this.baseImageLoaderStrategy=baseImageLoaderStrategy;
        return this;
    }

    public void loadImageView(Context context, String url, ImageView imageView){
        if(baseImageLoaderStrategy==null){
            baseImageLoaderStrategy=new UniverseImageLoaderStrategy();
        }
        this.baseImageLoaderStrategy.loadImage(context,imageView,url);
    }
}
