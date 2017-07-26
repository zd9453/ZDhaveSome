package com.example.dongdongkeji.wangwangsocial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Toast;

import com.example.dongdongkeji.wangwangsocial.animation.AnimationActivity;
import com.example.dongdongkeji.wangwangsocial.drawlayout.DrawLayoutActivity;
import com.example.dongdongkeji.wangwangsocial.rongim.RongTestActivity;
import com.example.dongdongkeji.wangwangsocial.service.brodcasereciver.notify.DoThingActivity;
import com.example.dongdongkeji.wangwangsocial.sharelogin.LoginActivity;
import com.example.dongdongkeji.wangwangsocial.webview.WebActivity;

/**
 * 跳转各个效果页面
 *
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "------------tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics metrics = new DisplayMetrics();
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        defaultDisplay.getMetrics(metrics);

//        TypedArray windowStyle = getWindow().getWindowStyle();
        Log.d(TAG, "onCreate: ==========" + metrics);
        int dpi = metrics.densityDpi;
        Log.d(TAG, "onCreate: ------------" + dpi);
        float density = metrics.density;
        Log.d(TAG, "onCreate: ----------" + density);

    }

    public void go1(View view) {
        Toast.makeText(this, "go1", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, WebActivity.class));
    }

    public void go2(View view) {
        Toast.makeText(this, "go2", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, RongTestActivity.class));
    }

    public void go3(View view) {
        Toast.makeText(this, "go3", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, DoThingActivity.class));
    }

    public void go4(View view) {
        Toast.makeText(this, "go4", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, AnimationActivity.class));
    }

    public void go5(View view) {
        Toast.makeText(this, "go5", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void go6(View view) {
        Toast.makeText(this, "go6", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, DrawLayoutActivity.class));
    }
}
