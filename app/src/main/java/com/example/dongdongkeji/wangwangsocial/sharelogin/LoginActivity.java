package com.example.dongdongkeji.wangwangsocial.sharelogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dongdongkeji.wangwangsocial.R;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, PlatformActionListener {

    private ImageView wx, qq, xl;
    private static String TAG = "MY_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        wx = (ImageView) findViewById(R.id.wx_login);
        qq = (ImageView) findViewById(R.id.qq_login);
        xl = (ImageView) findViewById(R.id.xl_login);

        wx.setOnClickListener(this);
        qq.setOnClickListener(this);
        xl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wx_login:
                Toast.makeText(this, "微信登录", Toast.LENGTH_SHORT).show();
                Platform WeiXin = ShareSDK.getPlatform(Wechat.NAME);
                authorize(new Wechat());
                break;
            case R.id.qq_login:
                Toast.makeText(this, "QQ登录", Toast.LENGTH_SHORT).show();
                Platform qq = ShareSDK.getPlatform(QQ.NAME);
                qq.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Log.d(TAG, "onComplete: ==========" + platform.getName());
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {
                        Log.d(TAG, "onError: ===" + platform.getName() + "---" + platform.getId() + "---" + platform.getDb());
                        Log.d(TAG, "onError: -===========" + i);
                        Log.d(TAG, "onError: =======" + throwable.toString());
                        Log.d(TAG, "onError: ===============");
                    }

                    @Override
                    public void onCancel(Platform platform, int i) {
                        Log.d(TAG, "onCancel: =====================");
                    }
                });

                qq.showUser(null);

                break;
            case R.id.xl_login:
                Toast.makeText(this, "新浪微博登录", Toast.LENGTH_SHORT).show();

                Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
//回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
                weibo.setPlatformActionListener(new PlatformActionListener() {

                    @Override
                    public void onError(Platform arg0, int arg1, Throwable arg2) {
                        // TODO Auto-generated method stub
                        arg2.printStackTrace();

                        Log.d(TAG, "onError: ======================");
                    }

                    @Override
                    public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                        // TODO Auto-generated method stub
                        //输出所有授权信息
                        arg0.getDb().exportData();
                        Log.d(TAG, "onComplete: ================" + arg0.getName());
                        Log.d(TAG, "onComplete:  ---------" + arg2.toString());

                        Log.d(TAG, "onComplete: ==========name " + arg2.get("name"));
                        Log.d(TAG, "onComplete: ==========head_img " + arg2.get("avatar_hd"));
                    }

                    @Override
                    public void onCancel(Platform arg0, int arg1) {
                        // TODO Auto-generated method stub
                        Log.d(TAG, "onCancel: ============授权取消");
                    }
                });
                //authorize与showUser单独调用一个即可
//                weibo.authorize();//单独授权,OnComplete返回的hashmap是空的
                weibo.showUser(null);//授权并获取用户信息
//                移除授权
                weibo.removeAccount(true);
                break;
            default:
                break;
        }
    }

    private void authorize(Platform plat) {
        if (plat == null) {
            return;
        }
//判断指定平台是否已经完成授权
        if (plat.isAuthValid()) {
            String userId = plat.getDb().getUserId();
            if (userId != null) {
                Log.d(TAG, "authorize: ====================已授权");
                return;
            }
        }

        plat.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Log.d(TAG, "onComplete: =============");
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Log.d(TAG, "onError: ================");
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Log.d(TAG, "onCancel: ==================");
            }
        });
        // true不使用SSO授权，false使用SSO授权
        plat.SSOSetting(true);
        //获取用户资料
        plat.showUser(null);
//        plat.removeAccount(true);
    }

    private void authorize1(Platform plat) {
        if (plat.isAuthValid()) {
            String userId = plat.getDb().getUserId();
            if (!TextUtils.isEmpty(userId)) {

                return;
            }
        }
        plat.setPlatformActionListener(this);
        plat.SSOSetting(true);
        plat.showUser(null);
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {

    }
}
