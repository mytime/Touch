package com.jikexueyuan.touchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * 触摸事件传递机制
 */
public class MainActivity extends AppCompatActivity {

//    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tv = (TextView) findViewById(R.id.txt);

        //触摸事件
//        tv.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                System.out.println("touch textview");
//                return false;
//            }
//        });
    }
}
