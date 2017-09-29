package com.veryworks.android.tetris;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by pc on 9/29/2017.
 */

public class Block {
    float x,y, unit;
    Paint paint;
    Parent parent = null;

    public Block(Property property){
        x= property.x;
        y= property.y;
        unit= property.unit;
        paint= property.paint;
    }

    // 나를 그리는 함수
    public void onDraw(Canvas canvas){
        if(parent != null){
            canvas.drawRect(
                    parent.getX() + x,
                    parent.getY() + y,
                    parent.getX() + x + unit,
                    parent.getY() + y + unit,
                    paint);
        }else{
            canvas.drawRect(
                    x,
                    y,
                    x + unit,
                    y + unit,
                    paint);
        }


    }

    // 이동함수
    public void up(){
        y = y - unit;
    }
    public void down(){
        y = y + unit;
    }
    public void right(){
        x = x + unit;
    }
    public void left(){
        x = x - unit;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public interface Parent {
        float getX();
        float getY();
    }
}
