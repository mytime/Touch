package com.jikexueyuan.dragthepic;

import android.app.ActionBar;
import android.graphics.Rect;
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
    private int notifiHeight;
    private ImageView moveImageView;

    private float diffX;
    private float diffY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        rootView = getLayoutInflater().inflate(R.layout.activity_main, null);
        //发送一个新线程请求
        rootView.post(new Runnable() {
            @Override
            public void run() {
                //ActionBar
                if (getSupportActionBar() != null) {
                    //获取actionBar高度
                    actionBarHeight = getSupportActionBar().getHeight();

                    //获取动态拦的高度
                    Rect frame = new Rect();
                    getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
                    notifiHeight = frame.top;
                }

            }
        });

        imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //兼容模式获取触摸事件
        int actionTag = MotionEventCompat.getActionMasked(event);

        //下标
        int pointIndex = MotionEventCompat.getActionIndex(event);
        switch (actionTag) {
            case MotionEvent.ACTION_DOWN:

                //图片初始位置
                RelativeLayout.LayoutParams downParams =
                        (RelativeLayout.LayoutParams) imageView.getLayoutParams();

                //点击区域在图片内
                if (getTouchXPotion(event, pointIndex) > downParams.leftMargin
                        && getTouchXPotion(event, pointIndex) < downParams.leftMargin + imageView.getWidth()
                        && getTouchYPotion(event, pointIndex) - actionBarHeight - notifiHeight > downParams.topMargin
                        && getTouchYPotion(event, pointIndex) - actionBarHeight - notifiHeight < downParams.topMargin + imageView.getHeight()) {

                    moveImageView = imageView;

                    //X轴差值
                    diffX = getTouchXPotion(event,pointIndex) - downParams.leftMargin;
                    //Y轴差值
                    diffY = getTouchYPotion(event,pointIndex) - downParams.topMargin;
                }


                break;
            case MotionEvent.ACTION_MOVE:

                if (moveImageView != null) {
                    //获取图片布局属性
                    RelativeLayout.LayoutParams param = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    //获取X坐标
                    param.leftMargin = (int) (getTouchXPotion(event, pointIndex) - diffX);
                    //获取Y坐标
                    param.topMargin = (int) (getTouchYPotion(event,
                            pointIndex)-diffY - actionBarHeight-notifiHeight);

                    //设置属性
                    imageView.setLayoutParams(param);
                }


                break;
            case MotionEvent.ACTION_UP:

                //抬起时清空
                moveImageView = null;
                break;
        }


        return super.onTouchEvent(event);
    }

    //触摸X地址
    private float getTouchXPotion(MotionEvent event, int pointIndex) {
        return MotionEventCompat.getX(event, pointIndex);
    }

    //触摸Y地址
    private float getTouchYPotion(MotionEvent event, int pointIndex) {
        return MotionEventCompat.getY(event, pointIndex);
    }
}
