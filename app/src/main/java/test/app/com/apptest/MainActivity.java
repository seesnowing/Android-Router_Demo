package test.app.com.apptest;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import test.app.com.apptest.strategy_study.GlideImageLoaderStategy;
import test.app.com.apptest.strategy_study.ImageLoadUtils;
import test.app.com.apptest.views.LoadingBarView;
import test.app.com.apptest.views.LoadingDialog;

import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.Route;
import com.signalman.app.SignalMan;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @ViewById
    public TextView jumpId;
    ImageView imageView;

    @AfterViews
    void afterView(){
        jumpId=findViewById(R.id.jumpId);
        jumpId.setOnClickListener(this);
        imageView=findViewById(R.id.imageView);
     }

    //test code
    void  testAppCode(){
        //#2.txt
    }

    //loadImageView
    void loadImage(){
        String url="http://pic19.nipi3267358_2.jpg";
        ImageLoadUtils.getInstance()
                .setBaseImageLoaderStrategy(new GlideImageLoaderStategy())
                .loadImageView(this,url,imageView);
    }

    //router test
    void routerJump(){
        Router.build("libararyBActivity").with("value","123").go(this);
    }

    // component调用
    void intentRun(){
        Intent intent=new Intent();
        intent.putExtra("key","karry");
        SignalMan.getInstance().go(this,intent,
                "test.app.com.libraryb.librarybActivity");
    }

    LoadingDialog dialog;
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.jumpId){
            intentRun();
        }
    }



}
