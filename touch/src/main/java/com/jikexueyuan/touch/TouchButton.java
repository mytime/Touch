package com.jikexueyuan.touch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * 按钮Touch事件
 */
public class TouchButton extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_button);

        findViewById(R.id.btn).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.btn:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("down");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        System.out.println("move");
                        break;
                    case MotionEvent.ACTION_UP:
                        System.out.println("up");
                }
        }

        return false;
    }
}
