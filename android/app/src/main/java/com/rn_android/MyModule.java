package com.rn_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.update.ui.JavaActivity;

public class MyModule extends ReactContextBaseJavaModule {
    public Context myContext;


    public MyModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Test.myContext = reactApplicationContext;
        myContext = reactApplicationContext;

    }

    @Override
    public String getName() {
        return "MyModule";
    }

    @ReactMethod
    public void NativeMethod() {
        new Test().fun();
    }

    @ReactMethod
    public void showTime() {
        new Test().getTime();
    }

    @ReactMethod
    public void showToast(String msg) {
        Toast.makeText(myContext, msg, Toast.LENGTH_SHORT).show();
    }

    @ReactMethod
    public void update(String mUpdateUrl) {
//        AppCompatActivity currentActivity = (AppCompatActivity) getCurrentActivity();
//        FragmentActivity currentActivity = (FragmentActivity) getCurrentActivity();
//        Activity currentActivity = getCurrentActivity();
//        new Test().update(currentActivity, mUpdateUrl);
        myContext.startActivity(new Intent(myContext, JavaActivity.class));

    }
    @ReactMethod
    public void dirUpdate(String mUpdateUrl) {
        new Test().dirUpdate(getCurrentActivity(),mUpdateUrl);

    }
}
