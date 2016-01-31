package com.jikexueyuan.velocitytracker;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;

/**
 * 获取滑动速度
 */
public class MainActivity extends AppCompatActivity {

    private VelocityTracker velocityTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //获取按下/移动/抬起动作事件（）
        //event.getAction() 旧用加法
        //event.getActionMasked() //google推荐用法
        //MotionEventCompat.getActionMasked(event); //兼容性写法
        int actionTag = MotionEventCompat.getActionMasked(event);

        //获取下标
        int actionIndex = MotionEventCompat.getActionIndex(event);

        //获取指针Id
        int pointId = MotionEventCompat.getPointerId(event, actionIndex);

        switch (actionTag) {
            case MotionEvent.ACTION_DOWN:
                if (velocityTracker == null) {
                    //获取velocityTracker实例
                    velocityTracker = velocityTracker.obtain();
                } else {
                    //清除值
                    velocityTracker.clear();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                //把event事件加入到velocityTracker类实例中。
                velocityTracker.addMovement(event);
                velocityTracker.computeCurrentVelocity(1000);//1秒内运动了多少像素

                //XY轴的速度
                System.out.println(String.format("X轴的速度：%f\tY轴的速度%f",
                        VelocityTrackerCompat.getXVelocity(velocityTracker, pointId),
                        VelocityTrackerCompat.getYVelocity(velocityTracker, pointId)));
                break;
            case MotionEvent.ACTION_UP:
                //速度回收
                velocityTracker.recycle();
                break;
        }
        return false;
    }
}
