/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.signalman.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

/**
 *   例子：跳转到libraryb 的一个activity, 叫librarybActivity.class
 *   Intent intent=new Intent();
 *         intent.putExtra("key","karry");
 *         SignalMan.getInstance().go(this,intent,
 *                 "test.app.com.libraryb.librarybActivity");
 *
 *
 */


public class SignalMan {

    public static SignalMan instance;
    private static String pkgName="";
    public static SignalMan getInstance(){
        if(instance==null){
            instance=new SignalMan();
        }
        return instance;
    }

    public void init(Context context){
        pkgName=context.getPackageName();
    }

    public void go(Context context,String className){
        Intent intent = new Intent();
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        ComponentName cn = new ComponentName(pkgName, className);
        intent.setComponent(cn);
        context.startActivity(intent);
    }

    public void go(Context context,Intent intent,String className){
        Intent i = intent;
        i.addCategory(Intent.CATEGORY_DEFAULT);
        ComponentName cn = new ComponentName(pkgName, className);
        intent.setComponent(cn);
        context.startActivity(intent);
    }

    public void go(Context context, String className, Bundle bundle){
        Intent intent = new Intent();
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        ComponentName cn = new ComponentName(pkgName, className);
        intent.setComponent(cn);
        ActivityCompat.startActivity(context,intent,bundle);
    }
}
