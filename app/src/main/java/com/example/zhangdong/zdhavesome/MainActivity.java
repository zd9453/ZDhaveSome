package com.example.zhangdong.zdhavesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.zhangdong.zdhavesome.webview.WebActivity;

/**
 * 跳转各个效果页面
 *
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void go1(View view) {
        Toast.makeText(this, "go1", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, WebActivity.class));
    }
}
