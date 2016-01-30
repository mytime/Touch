package com.jikexueyuan.touch;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * 获取屏幕上触摸个数
 * 获取单个触摸坐标和多个触摸坐标
 */
public class GetPointerCount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pointer_count);
    }

    //Compat 兼容
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取屏幕上手指头个数
        System.out.println(MotionEventCompat.getPointerCount(event));

        //获取动作坐标的下标
        int actionIndex = MotionEventCompat.getActionIndex(event);


        //获取多点触摸坐标
        if(MotionEventCompat.getPointerCount(event) > 1){
            //第一个触摸坐标
            float touch1X = MotionEventCompat.getX(event,0);
            float touch1Y = MotionEventCompat.getX(event,0);

            //第二个触摸坐标
            float touch2X = MotionEventCompat.getX(event,1);
            float touch2Y = MotionEventCompat.getX(event,1);

            System.out.println(String.format("touch1X:%f\ttouch1Y:%f\ttouch2x:%f\ttouch2Y:%f",
                    touch1X,touch1Y,touch2X,touch2Y));

        }else{ //获取单点触摸坐标

            //获取横向坐标
            float touchX = MotionEventCompat.getX(event,actionIndex);
            //获取纵向坐标
            float touchY = MotionEventCompat.getY(event,actionIndex);

            System.out.println(touchX+"\t"+touchY);
        }

        return super.onTouchEvent(event);
    }
}
