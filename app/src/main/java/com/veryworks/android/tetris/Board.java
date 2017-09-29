package com.veryworks.android.tetris;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

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

    // 페인트
    Paint paint;

    int map[][] =
    {
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,9},
            {9,9,9,9,9,9,9,9,9,9,9},
    };

    public Board(float x, float y, int columns, int rows, float unit){
        this.unit = unit;
        this.x = x;
        this.y = y;
        this.columns = columns;
        this.rows = rows;

        this.paint = new Paint();
        paint.setColor(Color.rgb(100,100,255));
    }

    public void addBlock(Block block) {
        this.block = block;
        block.x = 4;
        block.setParent(this);
    }

    public void onDraw(Canvas canvas){
        // 자기 자신 그리기
        for(int v=0; v<map.length ; v++){
            for(int h=0 ; h<map[0].length ; h++){
                if(map[v][h] > 0){
                    canvas.drawRect(
                        ((x + h) * unit),
                        ((y + v) * unit),
                        ((x + h + 1) * unit),
                        ((y + v + 1) * unit),
                        paint);
                }
            }
        }
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

    public void up() {
        if(checkCollision("r",0)) {
            block.rotate();
        }
    }
    public void down() {
        if(checkCollision("y", 1) ) {
            block.y += 1;
        }
    }
    public void left() {
        if(checkCollision("x", -1) ) {
            block.x -= 1;
        }
    }
    public void right() {
        if(checkCollision("x", 1) ) {
            block.x += 1;
        }
    }

    private boolean checkCollision(String command, int value){
        boolean result = true;

        // 현재 map 배열과
        // 안에 들어있는 블럭의 배열을 비교
        int checkBlock[][] = block.current;
        if("r".equals(command)){
            checkBlock = block.getNext();
        }

        for(int v=0 ; v<4 ; v++){
            for(int h=0 ; h<4 ; h++){
                int blockCell = checkBlock[v][h];                      // 블럭의 셀 값

                int tempX = (int)block.x + h;
                if("x".equals(command)) tempX += value;
                int tempY = (int)block.y + v;
                if("y".equals(command)) tempY += value;

                // 체크하고자 하는 범위를 넘어가면 continue
                if(tempY >= map.length || tempX >= map[0].length
                        || tempY < 0 || tempX < 0){
                    continue;
                }

                int mapCell   = map[ tempY][ tempX]; // 맵의 셀 값
                if(blockCell > 0 && mapCell >0){
                    return false;
                }
            }
        }


        return result;
    }
}
