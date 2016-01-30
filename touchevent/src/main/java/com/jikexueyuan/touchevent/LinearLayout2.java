package com.jikexueyuan.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 第二层
 * Created by iwan on 2016/1/30.
 */
public class LinearLayout2 extends LinearLayout {

    public LinearLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //先执行，拦截触摸事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                logOut("onInterceptTouchEvent:down");
                break;
            case MotionEvent.ACTION_MOVE:
                logOut("onInterceptTouchEvent:move");
                break;
            case MotionEvent.ACTION_UP:
                logOut("onInterceptTouchEvent:up");
                break;
        }

        /**
         * false: 仅响应down 事件
         * ture: 返回move / up 事件
         */
        return super.onInterceptTouchEvent(ev);
    }

    //再执行，触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                logOut("onTouchEvent:down");
                break;
            case MotionEvent.ACTION_MOVE:
                logOut("onTouchEvent:move");
                break;
            case MotionEvent.ACTION_UP:
                logOut("onTouchEvent:up");
                break;
        }
        /**
         * false: 仅响应down 事件
         * ture: 返回move / up 事件
         */
        return true;
//     return super.onTouchEvent(event);
    }

    //输出
    public void logOut(String str){
        System.out.println("LinearLayout2"+str);
    }
}
