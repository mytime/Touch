package com.jikexueyuan.dragthepic;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * 移动图片
 */
public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private View rootView;
    private int actionBarHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        rootView = getLayoutInflater().inflate(R.layout.activity_main,null);
        //发送一个新新线程请求
        rootView.post(new Runnable() {
            @Override
            public void run() {
                //ActionBar
                if (getSupportActionBar() != null){
                    //获取actionBar高度
                    actionBarHeight = getSupportActionBar().getHeight();
                    // TODO: 2016/1/31  
                }

            }
        })

        imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //兼容模式获取触摸事件
        int actionTag = MotionEventCompat.getActionMasked(event);

        //下标
        int pointIndex = MotionEventCompat.getActionIndex(event);
        switch (actionTag){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                //获取图片布局属性
                RelativeLayout.LayoutParams param =
                        (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                //获取X坐标
                param.leftMargin = (int) getTouchXPotion(event,pointIndex);
                //获取Y坐标
                param.topMargin = (int) getTouchYPotion(event,pointIndex);

                //设置属性
                imageView.setLayoutParams(param);

                break;
            case MotionEvent.ACTION_UP:

                break;
        }


        return super.onTouchEvent(event);
    }

    //触摸X地址
    private float getTouchXPotion(MotionEvent event,int pointIndex){
        return MotionEventCompat.getX(event, pointIndex);
    }
    //触摸Y地址
    private float getTouchYPotion(MotionEvent event,int pointIndex){
        return MotionEventCompat.getY(event,pointIndex);
    }
}
