package test.app.com.apptest;

import com.signalman.app.SignalMan;

import android.app.Application;
import android.util.Log;

public class App  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SignalMan.getInstance().init(this);
        Log.d("========>","1");
    }
}
