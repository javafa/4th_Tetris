package com.veryworks.android.tetris;

/**
 * Created by pc on 9/29/2017.
 */

public class Setting {
    // 게임판의 크기
    int width;
    int height;
    // 게임판의 가로세로 개수
    int rows;
    int columns;
    // 기본크기
    float unit;

    public Setting(int width, int height, int rows, int columns){
        this.width = width;
        this.height = height;
        this.rows = rows;
        this.columns = columns;

        unit = width/rows;
    }
}
