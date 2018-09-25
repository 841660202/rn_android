package com.rn_android;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.rn_android.util.UpdateAppHttpUtil;
import com.vector.update_app.UpdateAppManager;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.UpdateAppUtils;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Administrator on 2016/10/30.
 */

public class Test {

    //定义上下文对象
    public static ReactContext myContext;

    //定义发送事件的函数
    public void sendEvent(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
        System.out.println("reactContext=" + reactContext);

        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    public void fun() {
        //在该方法中开启线程，并且延迟3秒，然后向JavaScript端发送事件。
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //发送事件,事件名为EventName
                WritableMap et = Arguments.createMap();
                sendEvent(myContext, "EventName", et);


            }
        }).start();

    }

    public void getTime() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());   //获取当前时间
        String s = formatDate.format(date);

        Log.e("HHH", s);
        Toast.makeText(myContext, s, Toast.LENGTH_SHORT).show();

    }

    public void update(Activity activity, String mUpdateUrl ){
//        startActivity(new Intent(MainActivity, JavaActivity.class));
//        Log.e("HHH", String.valueOf(activity));
//        Log.e("HHH", mUpdateUrl);
//        new UpdateAppManager
//                .Builder()
//                //当前Activity
//                .setActivity(activity)
//                //更新地址
//                .setUpdateUrl(mUpdateUrl)
//                //实现httpManager接口的对象
//                .setHttpManager(new UpdateAppHttpUtil())
//                .build()
//                .update();






//        String apkPath =  "http://issuecdn.baidupcs.com/issue/netdisk/apk/BaiduNetdisk_7.15.1.apk";
//        UpdateAppUtils.from(activity)
//                .checkBy(UpdateAppUtils.CHECK_BY_VERSION_NAME) //更新检测方式，默认为VersionCode
//                .serverVersionCode(2)
//                .serverVersionName("2.0")
//                .apkPath(apkPath)
//                .showNotification(true) //是否显示下载进度到通知栏，默认为true
//                .updateInfo("新增加连接原生升级功能")  //更新日志信息 String
//                .downloadBy(UpdateAppUtils.DOWNLOAD_BY_APP) //下载方式：app下载、手机浏览器下载。默认app下载
//                .isForce(false) //是否强制更新，默认false 强制更新情况下用户不同意更新则不能使用app
//                .update();
    }
    public void dirUpdate(String mUpdateUrl ){

    }
}

