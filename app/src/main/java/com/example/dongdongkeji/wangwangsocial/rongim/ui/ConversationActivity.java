package com.example.dongdongkeji.wangwangsocial.rongim.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dongdongkeji.wangwangsocial.R;

import io.rong.imkit.RongIM;

/**
 * use to IM 聊天页
 * Created by zhangdong on 2017/6/8.
 *
 * @version 1.0
 */
public class ConversationActivity extends AppCompatActivity {

    private Button back;
    private TextView userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        back = (Button) findViewById(R.id.bt_back);
        userId = (TextView) findViewById(R.id.user_id);

        String userId = RongIM.getInstance().getCurrentUserId();


        this.userId.setText("当前用户id：" + (userId != null ? userId : "没有获取到用户id"));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
