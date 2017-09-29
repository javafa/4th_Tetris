package com.veryworks.android.tetris;

/**
 * 테트리스 게임이 진행되는 영역 클래스
 */

public class Board implements Block.Parent{

    float unit;


    public Board() {

    }

    public void addBlock(Block block) {
        block.setParent(this);
    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY() {
        return 0;
    }
}
