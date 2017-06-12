package com.example.zhangdong.zdhavesome.rongim.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangdong.zdhavesome.R;

import java.util.HashMap;
import java.util.Map;

import io.rong.imkit.RongIM;

/**
 * 好友列表
 *
 * @version 1.0
 */
public class MyFriendListActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView talk_one, talk_two, talk_zd;
    private Button back_bt;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userId = getIntent().getStringExtra("user_id");
        setContentView(R.layout.activity_my_friend_list);
        talk_one = (TextView) findViewById(R.id.talk_one);
        talk_two = (TextView) findViewById(R.id.talk_two);
        talk_zd = (TextView) findViewById(R.id.talk_zd);
        back_bt = (Button) findViewById(R.id.bt_back);

        if ("1".equals(userId)) {
            talk_one.setVisibility(View.GONE);
        }
        if ("2".equals(userId)) {
            talk_two.setVisibility(View.GONE);
        }
        if ("zhangdong".equals(userId)) {
            talk_zd.setVisibility(View.GONE);
        }
        talk_one.setOnClickListener(this);
        talk_two.setOnClickListener(this);
        talk_zd.setOnClickListener(this);
        back_bt.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.talk_one:
                Toast.makeText(this, "talk_one", Toast.LENGTH_SHORT).show();
                RongIM.getInstance().startPrivateChat(this, "1", "talk with 1");
                break;
            case R.id.talk_two:
                Toast.makeText(this, "talk_two", Toast.LENGTH_SHORT).show();
                RongIM.getInstance().startPrivateChat(this, "2", "talk with 2");
                break;
            case R.id.talk_zd:
                Toast.makeText(this, "talk_zd", Toast.LENGTH_SHORT).show();
                RongIM.getInstance().startPrivateChat(this, "zhangdong", "talk with zhangdong");
                break;
            case R.id.bt_back:
                finish();
                break;
            default:
                break;
        }

    }

    public void gotolist(View view) {
        Map<String, Boolean> map = new HashMap<>();

        RongIM.getInstance().startConversationList(this, map);

    }
}
