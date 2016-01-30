package com.jikexueyuan.touch;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * 获取按下，抬起，移动事件
 */
public class GetAction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_action);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //Motion:动作

//        System.out.println(event.getAction()); //旧用加法
//        System.out.println(event.getActionMasked()); //google推荐用法
//        System.out.println(MotionEventCompat.getActionMasked(event)); //兼容性写法

        /**
         * 第一种写法：使用getAction
         */
//        switch (event.getAction()){


        /**
         * 第二种写法：使用MotionEventCompat.getActionMasked(event)
         */
        int actionTag = MotionEventCompat.getActionMasked(event);
        switch (actionTag) {
            //按下时的动作
            case MotionEvent.ACTION_DOWN:
                System.out.println("down");
                break;
            //移动时的动作
            case MotionEvent.ACTION_MOVE:
                System.out.println("move");
                break;
            //抬起时的动作
            case MotionEvent.ACTION_UP:
                System.out.println("up");
                break;
        }


        return super.onTouchEvent(event);

    }
}
