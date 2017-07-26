package com.example.dongdongkeji.wangwangsocial.rongim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dongdongkeji.wangwangsocial.MyApplication;
import com.example.dongdongkeji.wangwangsocial.R;
import com.example.dongdongkeji.wangwangsocial.rongim.appinfo.TheBase;
import com.example.dongdongkeji.wangwangsocial.rongim.ui.MyFriendListActivity;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * 测试使用融云
 *
 * @version 1.0
 */
public class RongTestActivity extends AppCompatActivity {

    private MRongTalkCallBack mRongTalkCallBack = new MRongTalkCallBack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rong_test);

    }

    public void talk1(View view) {
        Toast.makeText(this, "login... goto friend list", Toast.LENGTH_SHORT).show();
        connect(TheBase.ONE_TOKEN);
    }

    public void talk2(View view) {
        Toast.makeText(this, "login... goto friend list", Toast.LENGTH_SHORT).show();
        connect(TheBase.TWO_TOKEN);
    }

    public void talk3(View view) {
        Toast.makeText(this, "login... goto friend list", Toast.LENGTH_SHORT).show();
        connect(TheBase.ZD_TOKEN);
    }

    /**
     * <p>连接服务器，在整个应用程序全局，只需要调用一次，需在 {@link #init(Context)} 之后调用。</p>
     * <p>如果调用此接口遇到连接失败，SDK 会自动启动重连机制进行最多10次重连，分别是1, 2, 4, 8, 16, 32, 64, 128, 256, 512秒后。
     * 在这之后如果仍没有连接成功，还会在当检测到设备网络状态变化时再次进行重连。</p>
     *
     * @param token    从服务端获取的用户身份令牌（Token）。
     * @param callback 连接回调。
     * @return RongIM  客户端核心类的实例。
     */
    private void connect(String token) {

        if (getApplicationInfo().packageName.equals(MyApplication.getCurProcessName(getApplicationContext()))) {
            RongIM.connect(token, mRongTalkCallBack);
        }
    }

    private class MRongTalkCallBack extends RongIMClient.ConnectCallback {
        /**
         * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
         * 2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
         */
        @Override
        public void onTokenIncorrect() {

        }

        /**
         * 连接融云成功
         *
         * @param s 当前 token 对应的用户 id
         */
        @Override
        public void onSuccess(String s) {
            Log.d("LoginActivity", "=====================================--onSuccess" + s);
            Intent intent = new Intent(RongTestActivity.this, MyFriendListActivity.class);
            intent.putExtra("user_id", s);
            startActivity(intent);
        }

        /**
         * 连接融云失败
         *
         * @param errorCode 错误码，可到官网 查看错误码对应的注释
         */
        @Override
        public void onError(RongIMClient.ErrorCode errorCode) {

        }
    }

}
