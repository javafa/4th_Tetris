package com.veryworks.android.tetris;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    // 0. 게임 세팅
    private static final int ROWS    = 18; // 게임 가로
    private static final int COLUMNS = 18; // 게임 세로
    private static Setting setting;        // 설정값

    FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 0. 게임 세팅
        setGame();
        // 1. 그림판을 준비
        initView();
    }

    private void setGame(){
        // 0. 화면의 사이즈를 구해서 게임판에 넘긴다\
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int height = metrics.heightPixels;
        int width  = metrics.widthPixels;
        setting = new Setting(width, height, ROWS, COLUMNS);
    }

    private void initView(){
        container = (FrameLayout) findViewById(R.id.container);
        Stage stage = new Stage(this, setting);
        // 뭔가 그릴것들을 다 준비해놔야 된다.
        stage.init();

        container.addView(stage);
    }



}
