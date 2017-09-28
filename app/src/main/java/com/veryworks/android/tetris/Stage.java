package com.veryworks.android.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by pc on 9/28/2017.
 */

public class Stage extends View {
    Paint paint;
    float stage_width;
    float stage_height;
    float unit;
    int unit_count;

    public Stage(Context context , int width, int height, int count) {
        super(context);
        stage_width = width;
        stage_height = height;
        unit_count = count;
        unit = stage_width / unit_count;

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 화면에 10 x 10 격자무늬를 그려보세요
        for(int i=0 ; i<unit_count ;i++){
            for(int j=0 ; j<unit_count ; j++){
                canvas.drawRect(
                         unit * i         // 0  0   0
                        ,unit * j         // 0  50  100
                        ,unit * (i + 1)   // 50 50  50
                        ,unit * (j + 1)   // 50 100 150
                        ,paint);
            }
        }
    }
}
