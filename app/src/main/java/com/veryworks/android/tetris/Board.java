package com.veryworks.android.tetris;

import android.graphics.Canvas;

/**
 * 테트리스 게임이 진행되는 영역 클래스
 */

public class Board implements Block.Parent{

    // 크기단위
    float unit;
    // 좌표
    float x;
    float y;
    // 가로 세로 사이즈
    int columns;  // pixel = columns * unit
    int rows;     // pixel = rows * unit

    // 현재 보드에서 동작하는 블럭
    Block block;

    public Board(float x, float y, int columns, int rows, float unit){
        this.unit = unit;
        this.x = x;
        this.y = y;
        this.columns = columns;
        this.rows = rows;
    }

    public void addBlock(Block block) {
        this.block = block;
        block.x = 4;
        block.setParent(this);
    }

    public void onDraw(Canvas canvas){
        // 자기 자신 그리기

        // 가지고 있는 유닛 그리기
        block.onDraw(canvas);
    }

    @Override
    public float getX() {
        return x * unit;
    }

    @Override
    public float getY() {
        return y * unit;
    }
}
