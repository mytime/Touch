package com.jikexueyuan.touch;

import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * GetAction :          获取按下，抬起，移动事件
     * GetPoninterCount:    获取屏幕上触摸个数
     *                      获取单个触摸坐标和多个触摸坐标
     * TouchButton:         按钮Touch事件
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btnDownUpMove).setOnClickListener(this);
        findViewById(R.id.btnPointerCount).setOnClickListener(this);
        findViewById(R.id.btnButtonTouch).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDownUpMove:
                startActivity(new Intent(this,GetAction.class));
                break;
            case R.id.btnPointerCount:
                startActivity(new Intent(this,GetPointerCount.class));
                break;
            case R.id.btnButtonTouch:
                startActivity(new Intent(this,TouchButton.class));
        }

    }
}
