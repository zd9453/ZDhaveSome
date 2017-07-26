package com.example.dongdongkeji.wangwangsocial.service.brodcasereciver.notify.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * use to test service
 * Created by zhangdong on 2017/6/13.
 *
 * @version 1.0
 */

public class MyService extends Service {

    private static String TAG = "MY_SERVICE";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ======================");
        return null;
    }

    public MyService() {
        super();
        Log.d(TAG, "MyService: ==========================");
    }

    /**
     * start service时调用，只有第一次创建时会调用一次，再次开启不会调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
/*
//前台服务开启
        Intent notificationIntent = new Intent(this, DoThingActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        Notification noti = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            noti = new Notification.Builder(this)
                    .setContentTitle("Title")
                    .setContentText("Message")
                    .setSmallIcon(R.drawable.rc_back_icon)
                    .setContentIntent(pendingIntent)
                    .build();
        }
        //startForeground()方法就是将服务设为前台服务。参数12346就是这个通知唯一的id，只要不为0即可。
        startForeground(12346, noti);
*/

        Log.d(TAG, "onCreate: =======================");
    }

    /**
     * startService时会调用
     *
     * @param intent  activity传递的intent
     * @param flags   标识
     * @param startId service 的id
     * @return .
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ===========================");
//        String s = intent.getStringExtra("test");
//        Log.d(TAG, "onStartCommand: ===============s = " + s + "=======flags " + flags + "=========startId " + startId);

        Log.d(TAG, "onStartCommand: =========" + Thread.currentThread().getId());
        Intent intent1 = new Intent();
        intent1.setAction(".service.brodcasereciver.notify.breadcase.mybreadcasereciver");
        this.sendBroadcast(intent1);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: =======================");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: =======================");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "onRebind: ====================");
    }

}
