package com.example.dongdongkeji.wangwangsocial.service.brodcasereciver.notify;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dongdongkeji.wangwangsocial.R;
import com.example.dongdongkeji.wangwangsocial.service.brodcasereciver.notify.breadcase.MyBreadcasrReciver;
import com.example.dongdongkeji.wangwangsocial.service.brodcasereciver.notify.service.MyService;

public class DoThingActivity extends AppCompatActivity {

    private ImageView img_map;
    private BroadcastReceiver mbr=new MyBreadcasrReciver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_thing);
        img_map = (ImageView) findViewById(R.id.img_map);


    }

    public void startSer(View v) {
        Toast.makeText(this, "start service to do something", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MyService.class);
        i.putExtra("test", "1111111111111111111");
        startService(i);
    }

    public void stopSer(View v) {
        Toast.makeText(this, "stop service", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MyService.class);
        stopService(i);
    }

}
