package com.example.dongdongkeji.wangwangsocial.animation;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.dongdongkeji.wangwangsocial.R;

public class AnimationActivity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener {

    private static final int REQUEST_CODE_IMAGE = 100;
    private TextView tv_world;
    private int widthPixels, heightPixels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        tv_world = (TextView) findViewById(R.id.tv_world);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        widthPixels = metrics.widthPixels;
        heightPixels = metrics.heightPixels;


        ViewTreeObserver viewTreeObserver = tv_world.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(this);


/*
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.my_anim);
        tv_world.startAnimation(animation);*/
        //属性动画
//        ObjectAnimator.ofFloat(tv_world1, "alpha", 1.0f, 0.0f).setDuration(5000).start();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void choce(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation((float) (tv_world.getX()), (float) (widthPixels * 0.5 - tv_world.getWidth() * 0.5),
                (float) (tv_world.getY() - tv_world.getHeight()),

                (float) (heightPixels * 0.5 - tv_world.getHeight() * 0.5));

        translateAnimation.setDuration(1000);
        tv_world.startAnimation(translateAnimation);

        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 4000, 0, 4000);
                scaleAnimation.setDuration(100);
                scaleAnimation.setFillBefore(true);
                tv_world.startAnimation(scaleAnimation);

                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        tv_world.setAnimation(null);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

//        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(intent, REQUEST_CODE_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
            }
        }
    }

    @Override
    public void onGlobalLayout() {
        int width = tv_world.getWidth();
        int height = tv_world.getHeight();
        Log.d("MY_INFO", "onGlobalLayout: =============width " + width + " height " + height);
    }
}
