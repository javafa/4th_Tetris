package com.veryworks.android.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * 게임 전체를 그려주는 클래스
 */

public class Stage extends View {
    Setting setting;

    Board board;
    Preview preview;

    public Stage(Context context, Setting setting) {
        super(context);

        this.setting = setting;
        // 보드와 프리뷰를 생성한다
        board = new Board();
        preview = new Preview(13, 1, 4, 4, setting.unit);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        preview.onDraw(canvas);
    }

    // 0. 화면을 최초에 그리기 전에 기본세팅
    public void init(){
        addBlockToPreview();
        addBlockToBoardFromPreview();
        addBlockToPreview();
    }

    // 1. 블럭을 생성하는 함수
    public Block newBlock(){
        Property property = new Property();
        property.x = 0;
        property.y = 0;
        property.paint = new Paint();
        property.paint.setColor(Color.RED);
        property.unit = setting.unit;
        return new Block(property);
    }
    // 2. 블럭을 preview 에 담는 함수
    public void addBlockToPreview(){
        Block block = newBlock();
        preview.addBlock(block);
    }
    // 3. 블럭을 preview 에서 Board로 옴기는 함수
    public void addBlockToBoardFromPreview(){
        Block block = preview.popBlock();
        board.addBlock(block);
    }
}
