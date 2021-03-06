package com.example.dongdongkeji.wangwangsocial;

import android.app.ActivityManager;
import android.content.Context;

import com.mob.MobApplication;

import io.rong.imkit.RongIM;

/**
 * use to
 * Created by zhangdong on 2017/6/8.
 *
 * @version 2.1
 */

public class MyApplication extends MobApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        RongIM.init(this);
        /**
         * OnCreate 会被多个进程重入，这段保护代码，确保只有您需要使用 RongIMClient 的进程和 Push 进程执行了 init。
         * io.rong.push 为融云 push 进程名称，不可修改。
         */
        /*if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext())) ||
                "io.rong.push".equals(getCurProcessName(getApplicationContext()))) {
            RongIMClient.init(this);
        }*/
    }

    //获取当前进程名字
    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

}
