package test.app.com.apptest.views;

import java.util.logging.Handler;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import test.app.com.apptest.R;

/**
 * 使用方式。
 * dialog= new LoadingDialog(MainActivity.this);
 * dialog.show();
 *
 */

public class LoadingDialog {

    LoadingBarView loadingBarView;
    AlertDialog.Builder builder;
    Context mContext;

    public LoadingDialog(Context mCtx){
        builder=new AlertDialog.Builder(mCtx);
        this.mContext=mCtx;
    }

    AlertDialog dialog;
    public void show(){
        dialog=builder.create();
        dialog.setCanceledOnTouchOutside(false);
        View view=LayoutInflater.from(mContext).inflate(R.layout.test_load,null);
        loadingBarView=view.findViewById(R.id.loadBar);
        loadingBarView.startRunning();
        loadingBarView.setLoadStatusListener(new LoadingBarView.LoadStatues() {
            @Override
            public void loadEnd() {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setView(view);
        dialog.show();
    }

    public void dismiss(){
        loadingBarView.stopRunning();
    }
}
